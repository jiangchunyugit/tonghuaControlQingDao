package cn.thinkfree.service.project;

import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.*;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {

    /**
     * 汇总公司项目情况
     * @param companyRelationMap
     * @return
     */
    IndexProjectReportVO countProjectReportVO(List<String> companyRelationMap);


    /**
     * 根据项目编号查询项目信息
     * @param projectNo 项目编号
     * @return 项目信息
     */
    Project findByProjectNo(String projectNo);

    /**
     * 根据项目信息获取房屋类型
     * @param project 项目信息
     * @return 房屋类型
     */
    String getHouseType(Project project);

    /**
     * 分页查询项目信息
     * @param projectSEO
     * @return
     */
    PageInfo<ProjectVO> pageProjectBySEO(ProjectSEO projectSEO);

    /**
     * 删除项目根据项目主键
     * @param  projectNo
     * @return
     */
    String deleteProjectByProjectNo(String projectNo);

    /**
     * 停工
     * @param projectNo
     * @return
     */
    String updateProjectStateForStop(String projectNo);

    /**
     * 查询项目详情 根据项目编号
     * @param projectNo
     * @return
     */
    ProjectDetailsVO selectProjectDetailsVOByProjectNo(String projectNo);

    /**
     * 根据职位查询员工
     * @param job   职位
     * @param filter 过滤条件
     * @return
     */
    List<StaffsVO> selectStaffsByJob(String job, String filter);

    /**
     *  查询项目报价单
     * @param projectNo
     * @return
     */
    ProjectQuotationVO selectProjectQuotationVoByProjectNo(String projectNo);

    /**
     * 编辑报价单
     * @param projectQuotationVO
     * @return
     */
    String editQuotation(ProjectQuotationVO projectQuotationVO);

    /**
     * 项目上线
     * @param projectDetailsVO
     * @return
     */
    String updateProjectForUpOnline(ProjectDetailsVO projectDetailsVO);

    /**
     * 移交项目
     * @param projectTransferVO
     * @return
     */
    String updateProjectByTransfer(ProjectTransferVO projectTransferVO);


    /**
     * 项目图表 总览
     * @param firstDayOfWeek
     * @param lastDayOfWeek
     * @return
     */
    List<IndexProjectChartItemVO> summaryProjectChart(LocalDate firstDayOfWeek, LocalDate lastDayOfWeek);


    /**
     *  查询一个员工参与的项目
     * @param userID
     * @param status
     * @param rows
     * @param page
     * @return
     */
    PageInfo<ProjectVO> selectProjectVOForPerson(String userID,Integer status,Integer rows,Integer page);

    /**
     * 汇总一个员工的所有项目状态
     * @param userID
     * @return
     */
    IndexProjectReportVO countProjectForPerson(String userID);

    /**
     * 根据项目编号查询主材信息
     * @param projectNo
     * @return
     */
    List<PreProjectMaterial> selectProjectMaterilsByProjectNo(String projectNo);

    /**
     * 编辑主材信息
     *
     * @param projectNo
     * @param preProjectMaterials
     *
     * @return
     */
    String editMaterials(String projectNo, List<PreProjectMaterial> preProjectMaterials);

    /**
     *  查询一个公司及子公司的项目
     * @param companyID
     * @param status
     * @param rows
     * @param page
     * @return
     */
    PageInfo<ProjectVO> selectProjectVOForCompany(String companyID,Integer status,Integer rows,Integer page);

    /**
     * 再次通知业主
     * @param phone
     * @return
     */
    String notifyOwner(String phone);


    /**
     * 判断业主是否已激活
     * @param projectNo
     * @return
     */
    Boolean selectOwnerIsActivatByProjectNo(String projectNo);

    /**
     * 上传项目资料包
     * @param projectDocumentContainer
     * @return
     */
    String uploadProjectDocuments(ProjectDocumentContainer projectDocumentContainer);

    /**
     * 查询项目资料包
     * @param projectNo
     * @return
     */
    List<ProjectDocument> listProjectDocuments(String projectNo);
}
