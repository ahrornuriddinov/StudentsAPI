package uz.najot.studentcontroller.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResMessage {
    private int statusCode;
    private String message;
    private Object data;

    public static ResMessage getSuccess(){
        return new ResMessage(0,"ok",null);
    }
    public static ResMessage getSuccess(Object data){
        return new ResMessage(0,"ok",data);
    }
}
