package cn.sanlijiankang.excel2pdf.Controller;

import cn.sanlijiankang.excel2pdf.Util.FileNameUtil;
import cn.sanlijiankang.excel2pdf.core.HttpResult.HttpResult;
import org.springframework.web.bind.annotation.*;


/**
 * Created by xxeNt
 * On 2020-09-14
 * Description:excel2pdf web控制器
 */
@RestController
@RequestMapping("Excel2Pdf")
public class Excel2PdfController {

    @PostMapping(value = "transfer")
    public HttpResult transferExcel2Pdf(@RequestParam String xlsFileName)  {
        String path = FileNameUtil.getFilePrefix(xlsFileName);
        //测试转换pdf
        String pdfFileName = path + ".pdf";
        System.out.println("pdf已转换完成！+path:" + pdfFileName);
        return HttpResult.ok(pdfFileName);
    }
}
