//package com.jimy.gateway.advice;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jimy.gateway.entity.ResultVO;
//import com.jimy.gateway.exception.APIException;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
///**
// * @Author: jimy
// * @Date: 2020/4/12 15:54
// * @Description:
// */
//@RestControllerAdvice(basePackages = {"com.jimy.*.controller"}) // 注意哦，这里要加上需要扫描的包
//public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
//        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
//        return !returnType.getGenericParameterType().equals(ResultVO.class);
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
//        // String类型不能直接包装，所以要进行些特别的处理
//        if (returnType.getGenericParameterType().equals(String.class)) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
//                return objectMapper.writeValueAsString(new ResultVO<>(data));
//            } catch (JsonProcessingException e) {
//                throw new APIException("返回String类型错误");
//            }
//        }
//        // 将原本的数据包装在ResultVO里
//        return new ResultVO<>(data);
//    }
//}