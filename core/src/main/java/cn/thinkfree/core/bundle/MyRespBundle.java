package cn.thinkfree.core.bundle;

/**
 * 自定义出参封装
 */
public class MyRespBundle<T> {

    /**
     * code
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
//    private Map<String,Object> datas;
    /**
     * 版本号
     */
    private String version;
    /**
     * 数据
     */
    private T data;
    /**
     * 时间戳
     */
    private Long timestamp;



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public MyRespBundle() {
    }

    public MyRespBundle(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyRespBundle{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", version='" + version + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
