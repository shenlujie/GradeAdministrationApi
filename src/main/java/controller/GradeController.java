package controller;


import com.alibaba.fastjson.JSONObject;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.*;
import utils.MsgJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/grade")
public class GradeController {


    @Autowired
    LoginService loginService;
    @Autowired
    StudentinfoService studentinfoService;
    @Autowired
    ScService scService;
    @Autowired
    CourseService courseService;
    @Autowired
    GradeInfoDetailsService gradeInfoDetailsService;

    @RequestMapping(value = "/getLogin",method = RequestMethod.POST)
    @ResponseBody
    public String getLogin(@RequestParam(value = "account")String account,
                           @RequestParam(value = "password")String password,
                           HttpSession session){
        Login login = loginService.selectByPrimaryKey(account);
        MsgJson msgJson = new MsgJson();
        if (null == login){
            msgJson.setSuccess(false);
            msgJson.setMessage("该账号不存在");
            msgJson.setObject(null);
        }else if (!password.equals(login.getPw())){
            System.out.print(login.getPw());
            msgJson.setSuccess(false);
            msgJson.setMessage("密码错误");
            msgJson.setObject(null);
        }else {
            msgJson.setSuccess(true);
            msgJson.setMessage("登录成功");
            session.setAttribute("user"+account,login);
        }
        Object loginJson = JSONObject.toJSON(msgJson);
        return JSONObject.toJSONString(loginJson);
    }


    @RequestMapping(value = "/getSignUp",method = RequestMethod.POST)
    @ResponseBody
    public String getSignUp(HttpServletRequest request){
        MsgJson msgJson = new MsgJson();

        String sno = request.getParameter("sno");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String classNo = request.getParameter("classNo");
        String dept = request.getParameter("dept");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        Login login = new Login();
        Studentinfo studentinfo = new Studentinfo();

        login.setAccount(sno);
        login.setPw(password);
        login.setIdentity(0);

        studentinfo.setSno(sno);
        studentinfo.setSname(name);
        studentinfo.setSsex(sex);
        studentinfo.setSage(age);
        studentinfo.setSclass(classNo);
        studentinfo.setSdept(dept);
        studentinfo.setStel(mobile);

        Login loginInfo = loginService.selectByPrimaryKey(sno);
        if (loginInfo != null){
            msgJson.setSuccess(false);
            msgJson.setMessage("该学号已被注册");
        }else {
            try {
                loginService.insert(login);
                studentinfoService.insert(studentinfo);
            } catch (Exception e) {
                e.printStackTrace();
                msgJson.setSuccess(false);
                msgJson.setMessage("服务器错误，注册失败");
            }

            msgJson.setSuccess(true);
            msgJson.setMessage("注册成功");
        }
        Object signUpJson = JSONObject.toJSON(msgJson);
        return JSONObject.toJSONString(signUpJson);
    }

    @RequestMapping(value = "/getGradeInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getGradeInfo(@RequestParam(value = "sno")String sno){
        MsgJson msgJson = new MsgJson();
        List<Sc> list = null;
        try {
            list = scService.selectGrade(sno);
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器错误，查询失败");
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("查询成功");
        msgJson.setObject(list);
        Object gradeInfoJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(gradeInfoJson);
    }

    @RequestMapping(value = "/getCourseInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getCourseInfo(){
        MsgJson msgJson = new MsgJson();
        List<Course> list = null;
        try {
            list = courseService.selectCourse();
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器错误，查询失败");
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("查询成功");
        msgJson.setObject(list);
        Object gradeInfoJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(gradeInfoJson);
    }

    @RequestMapping(value = "/getGradeInfoDetails",method = RequestMethod.POST)
    @ResponseBody
    public String getGradeInfoDetails(@RequestParam(value = "sno")String sno,@RequestParam(value = "cno")Integer cno){
        MsgJson msgJson = new MsgJson();
        GradeInfoDetails gradeInfoDetails = null;
        try {
            gradeInfoDetails = gradeInfoDetailsService.selectGradeInfoDetails(sno, cno);
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器错误，查询失败");
            Object gradeInfoJson = JSONObject.toJSON(msgJson);
            return JSONObject.toJSONString(gradeInfoJson);
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("查询成功");
        msgJson.setObject(gradeInfoDetails);
        Object gradeInfoJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(gradeInfoJson);
    }

    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getStudentInfo(@RequestParam(value = "sno")String sno){
        MsgJson msgJson = new MsgJson();
        Studentinfo studentinfo = null;
        try {
            studentinfo = studentinfoService.selectStudentInfo(sno);
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器错误，注册失败");
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("查询成功");
        msgJson.setObject(studentinfo);
        Object studentInfoJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(studentInfoJson);
    }

    @RequestMapping(value = "/getLogout",method = RequestMethod.POST)
    @ResponseBody
    public String getLogout(@RequestParam(value = "sno")String sno,HttpSession session){
        MsgJson msgJson = new MsgJson();
        Object logoutJson = null;
        try {
            session.removeAttribute("user"+sno);
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器错误，注销失败");
            logoutJson = JSONObject.toJSON(msgJson);
            return JSONObject.toJSONString(logoutJson);
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("注销成功");
        logoutJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(logoutJson);
    }

    @RequestMapping(value = "/updateStudentInfo",method = RequestMethod.POST)
    @ResponseBody
    public String updateStudentInfo(Studentinfo studentinfo){
        MsgJson msgJson = new MsgJson();
        Object studentInfoJson = null;
        try {
            studentinfoService.updateStudentInfo(studentinfo);
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器错误，查询失败");
            studentInfoJson = JSONObject.toJSON(msgJson);
            return JSONObject.toJSONString(studentInfoJson);
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("修改成功");
        studentInfoJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(studentInfoJson);
    }

    @RequestMapping(value = "/updateLoginInfo",method = RequestMethod.POST)
    @ResponseBody
    public String updateLoginInfo(Login login){
        MsgJson msgJson = new MsgJson();
        Object loginInfoJson = null;
        try {
            loginService.updateLoginInfo(login);
        } catch (Exception e) {
            e.printStackTrace();
            msgJson.setSuccess(false);
            msgJson.setMessage("服务器出现错误，查询失败");
            loginInfoJson = JSONObject.toJSON(msgJson);
            return JSONObject.toJSONString(loginInfoJson);
        }

        msgJson.setSuccess(true);
        msgJson.setMessage("修改成功");
        loginInfoJson = JSONObject.toJSON(msgJson);

        return JSONObject.toJSONString(loginInfoJson);
    }

}
