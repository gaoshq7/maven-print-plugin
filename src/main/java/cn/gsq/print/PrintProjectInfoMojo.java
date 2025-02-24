package cn.gsq.print;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Project : galaxy
 * Class : cn.gsq.print.PrintProjectInfoMojo
 *
 * @author : gsq
 * @date : 2024-01-19 09:11
 * @note : It's not technology, it's art !
 **/
@Mojo(name = "project-info", defaultPhase = LifecyclePhase.PACKAGE)
public class PrintProjectInfoMojo extends AbstractMojo {

    @Parameter(defaultValue = "${session}", readonly = true, required = true)
    private MavenSession session;

    /**
     * @Description : 执行输出信息逻辑
     * @Param : []
     * @Return : void
     * @Author : gsq
     * @Date : 14:53
     * @note : An art cell !
    **/
    @Override
    public void execute() {
        // 获取构建时间戳
        Properties psys = session.getSystemProperties();
        Properties pcurrent = session.getCurrentProject().getProperties();
        Properties puser = session.getUserProperties();
        // 数据预处理
        String editor = pcurrent.getProperty("project.editor");
        editor = StrUtil.isNotBlank(editor) ? editor : "未知";
        String time = pcurrent.getProperty("project.timestamp");
        Long timestamp = DateUtil.parse(StrUtil.isBlank(time) ? "" : time).getTime() / 1000;
        String timezone = psys.getProperty("user.timezone");
        timezone = StrUtil.isNotBlank(timezone) ? timezone : "未知时区";
        String mold = pcurrent.getProperty("project.mold");
        mold = StrUtil.isNotBlank(mold) ? mold : "stable";
        // 创建打印参数
        Map<String, String> content = new LinkedHashMap<>();
        content.put("编译作者", editor);
        content.put("源码版本", session.getCurrentProject().getVersion());
        content.put("安装类型", mold);
        content.put("所属时区", timezone);
        content.put("编译时间", time);
        content.put("时间戳", Convert.toStr(timestamp));
        // 打印
        print(content);
    }

    /**
     * @Description : 打印信息
     * @Param : [title, content]
     * @Return : Map<String, String>
     * @Author : gsq
     * @Date : 14:54
     * @note : An art cell !
    **/
    private void print(Map<String, String> report) {
        report.forEach((k, v) -> {
            super.getLog().info(PrintStyle.getStyle(
                    PrintStyle.COLOUR_WORD_PURPLE)
                    +
                    k + " : " + v
                    +
                    PrintStyle.getReset()
            );
        });
    }

}
