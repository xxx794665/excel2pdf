package cn.sanlijiankang.excel2pdf.Controller;

import cn.sanlijiankang.excel2pdf.Util.FileNameUtil;
import cn.sanlijiankang.excel2pdf.core.HttpResult.HttpResult;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;


/**
 * Created by xxeNt
 * On 2020-09-14
 * Description:excel2pdf web控制器
 */
@RestController
@RequestMapping("Excel2Pdf")
public class Excel2PdfController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DocumentConverter documentConverter;

    @PostMapping(value = "transfer")
    public HttpResult transferExcel2Pdf(@RequestParam String xlsFileName) throws  OfficeException {
        String path = FileNameUtil.getFilePrefix(xlsFileName);
        String fileType = FileNameUtil.getFileSuffix(xlsFileName);
        //测试转换pdf
        String pdfFileName = path + ".pdf";
        long startTime = System.currentTimeMillis();
        File in = new File(xlsFileName);
        File out = new File(pdfFileName);
        documentConverter.convert(in).to(out).execute();
        long covertTime = System.currentTimeMillis() - startTime;
        logger.info(String.format("successful convert:%s to %s in %dms", xlsFileName, "pdf", covertTime));
        return HttpResult.ok(out.getName());
    }
}
