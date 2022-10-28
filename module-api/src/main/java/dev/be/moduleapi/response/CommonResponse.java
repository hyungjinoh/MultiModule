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
    private String returnCode;
    private String returnMessage;
    private T info;

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