package org.doorisopen.myspring.Chat;

import java.util.ArrayList;
import java.util.List;
 
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import javax.websocket.RemoteEndpoint.Basic;

@Controller
@ServerEndpoint(value="/echo.do") // /myspring/echo.do url 요청을 통해 웹소켓에 접속함을 의미하는 애너테이션
public class ChatController {
	
	private static final List<Session> sessionList=new ArrayList<Session>();;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    public ChatController() {
        // TODO Auto-generated constructor stub
        System.out.println("웹소켓(서버) 객체생성");
    }
    @RequestMapping(value="/chat.do")
    public ModelAndView getChatViewPage(ModelAndView mav) {
        mav.setViewName("chat");
        return mav;
    }
    
    @OnOpen // 클라이언트가 웹소켓에 들어오고 서버에 아무런 문제 없이 들어왔을때 실행
    public void onOpen(Session session) {
        logger.info("Open session id:"+session.getId());
        String message = session.getId()+"님이 접속하셨습니다.";
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("Connection Established");
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sessionList.add(session);
        sendAllSessionToMessage(session, message);
    }
    /**
     * 모든 사용자에게 메시지를 전달한다.
     * @param self
     * @param message
     **/
    // 어떤 누군가에게 메시지가 왔다면 그 메시지를 보낸 자신을 제외한 연결된 세션(클라이언트)에게 메시지를 보내는 메소드
    private void sendAllSessionToMessage(Session self, String message) {
        try {
            for(Session session : ChatController.sessionList) {
                if(!self.getId().equals(session.getId())) {
                    session.getBasicRemote().sendText(message);
                }
            }
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    @OnMessage // 클라이언트에게 메시지가 들어왔을 때, 실행되는 메소드
    public void onMessage(String message, Session session) {
        logger.info("Message From "+message.split(":")[0] + ": "+message.split(":")[1]);
        try {
            final Basic basic = session.getBasicRemote();
            basic.sendText(message.split(":")[0]+"(me): "+message.split(":")[1]);
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, message);
    }
    @OnError
    public void onError(Throwable e, Session session) {
        
    }
    @OnClose // 클라이언트와 웹소켓과의 연결이 끊기면 실행되는 메소드입니다
    public void onClose(Session session) {
        logger.info("Session "+session.getId()+" has ended");
        String message = session.getId()+"님이 퇴장하셨습니다.";
        sendAllSessionToMessage(session, message);
        sessionList.remove(session);
    }
}