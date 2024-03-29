import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.junit.jupiter.api.Test;

public class TestAI {
    @Test
    public void test() {
        String accessKey = "6s79fihwbqimxso8865fevxsndood42g";
        String secretKey = "owiqfxbwd43m1dnvqfjq2wku69zl198f";
        YuCongMingClient client = new YuCongMingClient(accessKey, secretKey);

        // 构造请求
        DevChatRequest devChatRequest = new DevChatRequest();
        // 使用的会话模型（助手）id
//        devChatRequest.setModelId(1651468516836098050L);
        devChatRequest.setModelId(1674320317113249793L);
//        devChatRequest.setModelId(1674217456220057601L);
//        devChatRequest.setModelId(1674229651398012929L);

        // 要发送的消息，不超过 1024 字
        devChatRequest.setMessage("1+1=");

        // 获取响应
        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        System.out.println(response.getData());

//        // 使用的会话模型（助手）id
//        response.setMessage("1+1=");
//        response = client.doChat(devChatRequest);
//        System.out.println(response.getData());
    }
}
