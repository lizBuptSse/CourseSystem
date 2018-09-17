/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Connection.DBConnection;
import Entity.Schedule;
import Entity.Students;
import Entity.Teachers;
import Session.ClassroomFacade;
import Session.CoursesFacade;
import Session.StudentsFacade;
import Session.TeachersFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author liyueyang
 */
@WebServlet(name = "Controller",
            loadOnStartup = 1,
            urlPatterns = {"/register",
                           "/student",
                           "/teacher",
                           "/register_success",
                           "/register_fail",
                           "/login_success",
                           "/login_fail",
                           "/student_elective",
                           "/student_delete",
                           "/student_schedule",
                           "/logout",
                           "/student_home",
                           "/teacher_home"
                           
                           })
public class ControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private ClassroomFacade classroomFacade;
    @EJB
    private CoursesFacade courseFacade;
    @EJB
    private StudentsFacade studentsFacade;
    @EJB
    private TeachersFacade teachersFdacade;
    private DBConnection dbconn;
    private Students student_now;
    private Teachers teacher_now;
              
    @Override
    public void init() throws ServletException {

        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        // use RequestDispatcher to forward request internally
        if (userPath.equals("/register_success")) {
            
            String SNo=request.getParameter("No");
            String SName=request.getParameter("Name");
            String SPassWord=request.getParameter("Password");
            String SConfirm=request.getParameter("Confirm");
            
            String warning="注册失败！\n";
            if (SNo==null || SName==null || SPassWord==null || SConfirm==null){
                warning+="信息不能为空！\n";
                userPath="/register_fail";
            }
            else if  (!SPassWord.equals(SConfirm)){
                warning+="密码不匹配！\n";
                userPath="/register_fail";
            }
            else{
                try{
                    dbconn=new DBConnection();
                    String sql;
                    sql="select * from students where SNO="+SNo;
                    ResultSet rs=dbconn.query(sql);
                    if (rs.next()){
                        warning+="用户已存在！\n";
                        userPath="/register_fail";
                        
                    }
                    else{
                        Students student_new=new Students(SNo,SName,SPassWord);
                        String orl="insert into students value(?,?,?)";
                        dbconn.insert_student(orl,student_new);
                    }
                }catch(Exception e)	
                {
                }
            }
            request.setAttribute("warning",warning);
        }
        else if (userPath.equals("/login_success")){
            
            try {
                String No=request.getParameter("No");
                String PassWord=request.getParameter("Password");
                String id=request.getParameter("identity");
                String sql;
                dbconn=new DBConnection();
                String warning="登陆失败！\n";
                
                if ("teacher".equals(id)){
                    sql="select * from teachers where TNO="+No;
                    ResultSet rs=dbconn.query(sql);
                    if (rs.next()){
                        String sp=rs.getString("TPASSWORD");
                        if (!sp.equals(PassWord)){
                            warning+="密码错误！\n";
                            userPath="/login_fail";
                        }
                        else{
                            Teachers teacher=new Teachers(rs.getString("TNO"),rs.getString("TNAME"),rs.getString("TPASSWORD"));
                            request.setAttribute("teacher",teacher);
                            teacher_now=teacher;
                            userPath="/teacher";
                        }
                    }
                    else{
                        warning+="用户不存在！\n";
                        userPath="/login_fail";
                        
                    }
                }
                else if ("student".equals(id)){
                    sql="select * from students where SNO="+No;
                    ResultSet rs=dbconn.query(sql);
                    if (rs.next()){
                        String sp=rs.getString("SPASSWORD");
                        if (!sp.equals(PassWord)){
                            warning+="密码错误！\n";
                            userPath="/login_fail";
                        }
                        else{
                            Students student=new Students(rs.getString("SNO"),rs.getString("SNAME"),rs.getString("SPASSWORD"));
                            request.setAttribute("student",student);
                            student_now=student;
                            userPath="/student";
                        }
                    }
                    else{
                        warning+="用户不存在！\n";
                        userPath="/login_fail";
                        
                    }
                }
                else{
                    warning+="请选择用户类别！\n";
                    userPath="/login_fail";
                }
                request.setAttribute("warning",warning);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (userPath.equals("/student_elective")){
            try {
                Schedule[] sch=new Schedule[100];
                int course_time[][]=new int[6][8];
                for (int i=0;i<6;i++){
                    course_time[i]=new int[8];
                }
                int num=0;
                String sql,sql2,sql3,sql4;
                request.setAttribute("student",student_now);
                for (int i=1;i<6;i++){
                    for (int j=1;j<8;j++){
                        int k=0;
                        sql="select * from courses_in_classroom where TIMENO="+ String.valueOf(i)+" AND WEEKNO="+String.valueOf(j);
                        ResultSet rs=dbconn.query(sql);
                        while (rs.next()){
                            k++;
                            sql2="select * from courses where CNO="+ rs.getString("courses_CNO");
                            ResultSet rs2=dbconn.query(sql2);
                            
                            if (rs2.next()){ 
                                sql3="select * from teachers where TNO="+ rs2.getString("teachers_TNO");
                                ResultSet rs3=dbconn.query(sql3);
                            
                                sql4="select * from classroom where ID="+ rs.getString("classroom_ID");
                                ResultSet rs4=dbconn.query(sql4);

                                if (rs3.next() && rs4.next()){
                                    sch[num]=new Schedule(rs.getString("courses_CNO"),rs2.getString("CNAME"),rs3.getString("TNAME")
                                                    ,i,rs4.getString("CLNO"),rs2.getInt("CKIND"),rs2.getInt("LEFTNUM"),j);
                                    num++;
                                }
                            }
                            
                            
                        }
                        course_time[i][j]=k;
                    }
                }
                request.setAttribute("course_time",course_time);
                request.setAttribute("schedule",sch);
                request.setAttribute("schedule_num",num);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (userPath.equals("/student_delete")){
            try {
                int k=0;
                Schedule[] sch=new Schedule[50]; 
                String sql,sql2,sql3;
                request.setAttribute("student",student_now);
                sql="select * from students_study_courses where SNO="+student_now.getSno();
                ResultSet rs=dbconn.query(sql);
                while (rs.next()){
                    sql2="select * from courses where CNO="+ rs.getString("courses_CNO");
                    ResultSet rs2=dbconn.query(sql2);
                            
                    if (rs2.next()){ 
                        sql3="select * from teachers where TNO="+ rs2.getString("teachers_TNO");
                        ResultSet rs3=dbconn.query(sql3);

                        if (rs3.next()){
                            sch[k]=new Schedule(rs.getString("courses_CNO"),rs2.getString("CNAME"),rs3.getString("TNAME"),rs2.getInt("CKIND"));
                            k++;
                        }
                    }
                }
                request.setAttribute("schedule",sch);
                request.setAttribute("schedule_num",k-1);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (userPath.equals("/student_schedule")){
            request.setAttribute("student",student_now);
        }
        else if (userPath.equals("/logout")){
            student_now=null;
            teacher_now=null;
            userPath="/index";
        }
        else if (userPath.equals("/student_home")){
            request.setAttribute("student",student_now);
            userPath="/student";
        }
        
        String url =userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        //doGet(request,response);
        // use RequestDispatcher to forward request internally
        String url =  userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}