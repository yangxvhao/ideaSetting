#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import com.alpha.business.common.model.query.base.StringQueryRequest;
import com.alpha.business.crawler.AbstractRegPageProcessor;
import com.alpha.common.enums.crawler.PlatformCodeEnum;
import com.alpha.common.utils.HttpMethod;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;

import java.text.ParseException;

/**
 * @author ${USER}
 * @date ${DATE}.
 */

@Component
@Slf4j
@CrawlerProxyType(type = CrawlerProxyTypeEnum.ONCE_WITHOUT_PROXY)
public class ${NAME} extends AbstractRegPageProcessor {
    public ${NAME}() {
        super(PlatformCodeEnum.REG);
    }

    @Override
    public Request gen(StringQueryRequest task) throws Exception {
        return Request.post("${url}").putExtra("mobile",task.getData());
    }

    @Override
    public PlatformCodeEnum.RegisterSiteResult parseResult(Page page) throws ParseException {
        log.info("result:{}",page.getRawText());
        /**
         * 
         */
        if("".equals(page.getJSONObject().getString(""))){
            return PlatformCodeEnum.RegisterSiteResult.REG;
        }else if("".equals(page.getJSONObject().getString(""))){
            return PlatformCodeEnum.RegisterSiteResult.NOT_REG;
        }
        return PlatformCodeEnum.RegisterSiteResult.ERROR;   
        
    }

    @Override
    protected Site getSite(Request request) {
        return Site.me()
                .addHeader("","")
                .nameValuePair(new NameValuePair[]{
                        new BasicNameValuePair("",String.valueOf(request.getExtra("mobile"))),
                })
                ;
    }

    public static void main(String[] args) {
    int count = 1;
        for (int i = 0; i < count; i++) {
        new ${NAME}().getSpider().processWithResponse(new StringQueryRequest("17091003126"));
    }
    }
}
