package cn.sanlijiankang.excel2pdf.Config;

import cn.sanlijiankang.excel2pdf.Excel2pdfApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by xxeNt
 * On 2020-09-25
 * Description:映射启动类
 */
public class MySpringBootServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Excel2pdfApplication.class);
    }
}
