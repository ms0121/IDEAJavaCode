package com.xxxx.crm3.service;

import com.xxxx.crm3.base.BaseService;
import com.xxxx.crm3.dao.UserMapper;
import com.xxxx.crm3.model.UserModel;
import com.xxxx.crm3.query.UserQuery;
import com.xxxx.crm3.utils.AssertUtil;
import com.xxxx.crm3.utils.Md5Util;
import com.xxxx.crm3.utils.PhoneUtil;
import com.xxxx.crm3.utils.UserIDBase64;
import com.xxxx.crm3.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-09-27 - 17:46
 */
@Service
public class UserService extends BaseService<User, Integer> {
    @Resource
    private UserMapper userMapper;

    /**
     * 登录的参数校验：
     *      1. 用户名不为空,
     *      2. 用户名对应的用户信息存在
     *      3. 密码不为空，并且正确
     * @param userName
     * @return
     */
    public UserModel userLogin(String userName, String password){
        // 判断用户名和密码是否为空
        checkLoginParams(userName, password);

        // 查询用户信息
        User user = userMapper.queryUserByUserName(userName);
        AssertUtil.isTrue(user==null, "用户名不存在!");

        // 校验密码是否正确
        checkUserPwd(password, user.getUserPwd());

        // 因为存在数据库中的用户密码是md5加密之后的数据，所以对输入过来的密码也进行加密
        AssertUtil.isTrue(!Md5Util.encode(password).equals(user.getUserPwd()), "密码不正确，请重新输入!");
        UserModel userModel = new UserModel();
        return builderUserModel(userModel, user);
    }

    // 返回User中的部分字段
    public UserModel builderUserModel(UserModel userModel, User user){
        userModel.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        return userModel;
    }

    // 校验密码是否正确
    private void checkUserPwd(String password, String pwd) {
        String encode = Md5Util.encode(password);
        AssertUtil.isTrue(!encode.equals(pwd), "密码不正确!");
    }

    // 判断用户名和密码是否为空
    private void checkLoginParams(String userName, String password) {
        AssertUtil.isTrue(StringUtils.isBlank(userName), "用户名不能为空!");
        AssertUtil.isTrue(StringUtils.isBlank(password), "密码不能为空!");
    }

    /**
     * 修改用户密码：
     *     1.参数校验：
     *          用户ID: userId 非空(controller判断)，用户对象必须存在
     *          原始密码：oldPassword 非空，需要与数据库中的加密密码保持一致
     *          新密码：newPassword 非空，与原密码不能相同
     *          确认密码：confirmPassword 非空，必须与新密码一致
     *
     * @param userId 当前登录用户的id(该密码是已经加密过的)
     * @param oldPassword 用户的原密码
     * @param newPassword 新密码
     * @param confirmPassword 确认密码
     */
    // 除了查询，增删改都需要添加事务控制
    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePassword(Integer userId, String oldPassword, String newPassword, String confirmPassword){
        AssertUtil.isTrue(userId == null, "用户Id不存在!");
        // 通过Id查询用户信息
        User user = userMapper.selectByPrimaryKey(userId);
        // 判断参数信息
        checkUserParams(user, oldPassword, newPassword, confirmPassword);
        // 设置用户的密码信息
        user.setUserPwd(Md5Util.encode(newPassword));
        // 更新用户密码
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) < 1, "用户密码更新失败!");
    }

    // 判断参数信息
    private void checkUserParams(User user, String oldPassword, String newPassword, String confirmPassword) {
        AssertUtil.isTrue(user == null, "用户未登录或用户不存在!");
        // 旧密码非空判断
        AssertUtil.isTrue(StringUtils.isBlank(oldPassword), "旧密码不能为空!");
        // 判断输入的旧密码是否等于数据库中的密码
        AssertUtil.isTrue(!user.getUserPwd().equals(Md5Util.encode(oldPassword)), "原密码不正确!");
        // 新密码不能为空，并且不能等于旧密码
        AssertUtil.isTrue(StringUtils.isBlank(newPassword), "新密码不能为空!");
        AssertUtil.isTrue(user.getUserPwd().equals(Md5Util.encode(newPassword)), "新旧密码不能相同!");
        // 确认密码不能为空，并且要和新密码相等
        AssertUtil.isTrue(StringUtils.isBlank(confirmPassword), "确认密码不能为空!");
        AssertUtil.isTrue(!newPassword.equals(confirmPassword), "确认密码和新密码不相同!");
    }


    /**
     * 参数校验
     * @param phone
     * @param email
     * @param trueName
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserInfo(Integer userId,String phone, String email, String trueName){
        AssertUtil.isTrue(userId == null, "用户Id不存在!");
        // 通过Id查询用户信息
        User user = userMapper.selectByPrimaryKey(userId);
        checkParams(user,phone, email, trueName);
//        User user1 = userMapper.queryUserByTrueName(trueName);
//        AssertUtil.isTrue(user1 != null, "该真实名字已存在,请重试!");
        user.setPhone(phone);
        user.setEmail(email);
//        user.setTrueName(trueName);
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) < 1, "用户密码更新失败!");
    }

    private void checkParams(User user, String phone, String email, String trueName) {
        AssertUtil.isTrue(user == null, "用户不存在");
        AssertUtil.isTrue(StringUtils.isBlank(phone), "手机号不能为空");
        AssertUtil.isTrue(!PhoneUtil.isMobile(phone), "手机号格式不正确");
        AssertUtil.isTrue(StringUtils.isBlank(email), "邮箱号不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(trueName), "真实名字不能为空");
    }

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<Map<String, Object>> queryAllSales(){
        return userMapper.queryAllSales();
    }

}
