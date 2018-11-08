package cn.thinkfree.service.remote;

import java.util.List;

import cn.thinkfree.database.model.SystemMessage;
import cn.thinkfree.database.vo.remote.SyncTransactionVO;

public interface CloudService {

    /**
     * 项目上线通知
     * @param projectNo 项目编码
     * @param status   项目状态
     * @return
     */
      RemoteResult<String> projectUpOnline(String projectNo, Short status);

    /**
     * 发送短信 激活码
     * @param phone   手机号
     * @param activeCode  激活码
     * @return
     */
      RemoteResult<String> sendSms(String phone,String activeCode);

    /**
     * 发送公告
     * @param systemMessage 公告
     * @param receive  接收人
     * @return
     */
      RemoteResult<String> sendNotice(SystemMessage systemMessage, List<String> receive);

      /**
       * 合同上传
       *  @param filepath
       */
      public String uploadFile(String fileName);

    /**
     * 同步公司信息
     * @param syncTransactionVO
     * @return
     */
      RemoteResult<String> syncTransaction(SyncTransactionVO syncTransactionVO);


    /**
     * 发送邮件
     * @param email
     * @param templateCode
     * @param para
     * @return
     */
      RemoteResult<String> sendEmail(String email,String templateCode,String para);
}
