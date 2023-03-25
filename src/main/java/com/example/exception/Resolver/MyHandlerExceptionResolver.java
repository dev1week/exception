package com.example.exception.Resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


        try {
            if(ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                //마치 try catch 하듯이 exception을 처리하여 정상흐름 처럼 변경'
                    //sendError호출로 서블릿에서 상태코드에 따른 오류를 처리하도록 위임한다.
                    //이후 was는 서블릿 오류 페이지를 찾아서 내부 호출한다.
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                //http상태코드는 400으로 지정하고, 빈 model and view를 지정한다.
                    //model and view를 지정할 경우 view와 model 등의 정보를 지정하여 뷰를 렌더링한다.
                    //null을 반환할 경우 다음 resolver를 호출한다. 처리할 수 있는 resolver가 없을 경우 서블릿 밖으로 예외를 던져버린다.

                return new ModelAndView();
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
        }
        return null;
    }
}
