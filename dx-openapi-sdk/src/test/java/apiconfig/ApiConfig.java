package apiconfig;

import lombok.Data;

/**
 * 商户的api请求配置信息，需商户配置（配置信息可向我方项目运营申请）
 */
@Data
public class ApiConfig {

    /**
     * 商户请求网关
     */
    private  final String baseUrl = "https://api.wallet-dev.com";
    /**
     * 商户api请求 key 用于识别商户身份
     */
    private  final String key = "9yUreYgTRtit39Dy";
    /**
     * 商户api请求secret  用于sign加密
     */
    private  final String secret = "D2PQPllGEBOV4mcMxoKTM7foVpzqrjIx";

}
