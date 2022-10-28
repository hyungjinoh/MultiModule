package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dev.be.modulecommon.enums.response.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    //멤버 변수 3개 : 리턴코드, 리턴메시지, 제너릭 클래스형태
    private String returnCode;
    private String returnMessage;
    private T info;

    //생성자 3개
    // CodeEnum 을 인자로 갖는것, 또는 제너릭 T만 받는것 ==> 항상성공
    // 3개의 멤버변수 모두 생성자 인자로 받는것

    //성공 메서드 => 빌더로 static CommonResponse 객체 생성하여 리턴
    public CommonResponse(CodeEnum codeEnum) {
        this(codeEnum, null);
    }

    public CommonResponse(T info) {
        //항상성공
        this(CodeEnum.SUCCESS, info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        setReturnCode(codeEnum);
        setInfo(info);
    }

    public void setReturnCode(CodeEnum codeEnum) {
        //리턴코드와 리턴메시지를 함께 세팅
        this.returnCode = codeEnum.getCode();
        this.returnMessage = codeEnum.getMessage();
    }

    public static CommonResponse success() {
        return builder()
                .returnCode(CodeEnum.SUCCESS.getCode())
                .returnMessage(CodeEnum.SUCCESS.getMessage())
                .build();
    }
}