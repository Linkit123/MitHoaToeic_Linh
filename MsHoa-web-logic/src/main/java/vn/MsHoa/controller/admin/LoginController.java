package vn.MsHoa.controller.admin;
import org.apache.log4j.Logger;
import vn.MsHoa.command.UserCommand;
import vn.MsHoa.core.common.constant.WebConstant;
import vn.MsHoa.core.dto.UserDTO;
import vn.MsHoa.core.service.impl.UserServiceImpl;
import vn.MsHoa.core.web.utils.FormUtil;
import vn.myclass.core.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by trinhngoclinh on 4/15/2018.
 */
@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        RequestDispatcher rd = request.getRequestDispatcher("views/web/login.jsp");
        rd.forward(request,response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        UserCommand command = FormUtil.populate(UserCommand.class,request);
        UserDTO pojo = command.getPojo();
        UserService userService=new UserServiceImpl();
            if (userService.isUserEntity(pojo)!=null){
                if (userService.finfRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)){
                    request.setAttribute(WebConstant.ALERT,WebConstant.TYPE_SUCCESS);
                    request.setAttribute(WebConstant.MESSAGE_RESPONSE,"Xin chào user!");
                }else if(userService.finfRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)){
                    request.setAttribute(WebConstant.ALERT,WebConstant.TYPE_SUCCESS);
                    request.setAttribute(WebConstant.MESSAGE_RESPONSE,"Xin chào admin!");
                }
            }else {
                request.setAttribute(WebConstant.ALERT,WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE,"Tên hoặc mật khẩu không chính xác!");
            }
        RequestDispatcher rd = request.getRequestDispatcher("views/web/login.jsp");
        rd.forward(request,response);
    }
}
//        String Em="vì sao trời mưa!";
//        try {
//         if (Em.equals("mưa")){
//             System.out.println("đăng nhập thành công!");
//         }
//        }catch (NullPointerException e) {
//            log.error
// ("Sóng bắt đầu từ đâu!");
//        }