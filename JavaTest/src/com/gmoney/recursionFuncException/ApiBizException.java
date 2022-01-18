package com.gmoney.recursionFuncException;

import lombok.Getter;

public class ApiBizException extends Exception {

    private static final long serialVersionUID = 8498939504681452511L;

    public enum MessageType { CODE, MESSAGE }

    @Getter
    private MessageType messageType;

    @Getter
    private String errorCode;

    @Getter
    private String message;

    @Getter
    private int responseBody;

    public ApiBizException(String message) {
        super(message);
        this.messageType = MessageType.MESSAGE;
        this.errorCode = null;
        this.message = message;
    }

    public ApiBizException(MessageType messageType, String message) {
        super(message);
        this.messageType = messageType;

        if (MessageType.CODE.equals(messageType)) {
            this.errorCode = message;
            this.message = "test";
        }
        else {
            this.errorCode = null;
            this.message = message;
        }
    }

    public ApiBizException(MessageType messageType, String message, int responseBody) {
        super(message);
        this.messageType = messageType;

        if (MessageType.CODE.equals(messageType)) {
            this.errorCode = message;
            this.message = "test";
        }
        else {
            this.errorCode = null;
            this.message = message;
        }

        this.responseBody = responseBody;
    }

    public ApiBizException(String errorCode, String message) {
        super(message);
        this.messageType = MessageType.CODE;
        this.errorCode = errorCode;
        this.message = "test";
    }

    public ApiBizException(MessageType messageType, String errorCode, String message) {
        super(message);
        this.messageType = messageType;
        this.errorCode = errorCode;
        this.message = message;
    }

    public ApiBizException(MessageType messageType, String errorCode, String message, int responseBody) {
        super(message);
        this.messageType = messageType;
        this.errorCode = errorCode;
        this.message = message;
        this.responseBody = responseBody;
    }

    public ApiBizException(String message, Throwable cause) {
        super(message, cause);
        this.messageType = MessageType.MESSAGE;
        this.errorCode = null;
        this.message = message;
    }

    public ApiBizException(MessageType messageType, String message, Throwable cause) {
        super(message, cause);
        this.messageType = messageType;

        if (MessageType.CODE.equals(messageType)) {
            this.errorCode = message;
            this.message = "test";
        }
        else {
            this.errorCode = null;
            this.message = message;
        }
    }

    public ApiBizException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.messageType = MessageType.CODE;
        this.errorCode = errorCode;
        this.message = "test";
    }

    public ApiBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.messageType = MessageType.MESSAGE;
        this.errorCode = null;
        this.message = message;
    }

    @Override
    public String getLocalizedMessage() {
        String localizedMessage = message;

        if (MessageType.CODE.equals(messageType) && errorCode != null && errorCode.contains(".")) {
            String codeMessage = "test";

            if (!errorCode.equals(codeMessage)) {
                localizedMessage = codeMessage;
            }
            else {
                localizedMessage = "test";
            }
        }

        return localizedMessage;
    }

}
