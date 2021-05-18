package cn.sanlijiankang.excel2pdf.Controller;

import cn.sanlijiankang.excel2pdf.Util.FileNameUtil;
import cn.sanlijiankang.excel2pdf.core.HttpResult.HttpResult;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by xxeNt
 * On 2021-01-17
 * Package: cn.sanlijiankang.excel2pdf.Controller
 * Description:word2pdf 控制器
 */
@RestController
@RequestMapping("Word2Pdf")
public class Word2PdfController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DocumentConverter documentConverter;

    @PostMapping(value = "transfer")
    public HttpResult transferExcel2Pdf(@RequestParam String docFileName) {
        try {
            String path = FileNameUtil.getFilePrefix(docFileName);
            String fileType = FileNameUtil.getFileSuffix(docFileName);
            //测试转换pdf
            String pdfFileName = path + ".pdf";
            long startTime = System.currentTimeMillis();
            File in = new File(docFileName);
            File out = new File(pdfFileName);
            documentConverter.convert(in).to(out).execute();
            long covertTime = System.currentTimeMillis() - startTime;
            logger.info(String.format("successful convert:%s to %s in %dms", docFileName, "pdf", covertTime));
            int startIndex = pdfFileName.indexOf("static");
            return HttpResult.ok(pdfFileName.substring(startIndex));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return HttpResult.error(docFileName + ":transferFail");
    }
}
