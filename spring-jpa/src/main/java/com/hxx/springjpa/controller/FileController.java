package com.hxx.springjpa.controller;

import com.hxx.springjpa.util.PdfUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @Author xin.hao
 * @create 2022/1/10 11:17
 */
@RestController
@AllArgsConstructor
@Slf4j
public class FileController {
    private final String PATH = "D:\\";

    /**
     * 删除文件
     * @param path
     */
    private static void deleteDirectoryStream(Path path) {
        try {
            Files.delete(path);
            log.info("删除文件成功: " + path.toString());
        } catch (IOException e) {
            log.info("无法删除的路径: " + path, e);
        }
    }

    /**
     * 预览
     * @param response
     * @param lawruleId
     * @throws Exception
     */
    @GetMapping("/getPreview")
    public void getPreview(HttpServletResponse response,  @RequestParam Long lawruleId)
            throws Exception {
File file = new File(PATH+File.separator+"aaa.docx");
        //删除目录下文件
//        Path path = Paths.get(PATH);
//        try (Stream<Path> walk = Files.walk(path)) {
//            walk.sorted().skip(1).forEach(FileController::deleteDirectoryStream);
//        }
//        Files.createDirectories(Paths.get(confyml.getPdfPath()));

        //获取主文件
//        CMISClient cmisClient = new CMISClient();
//        LawRuleAttaEntity mainFile = lawRuleService.getMainFile(lawruleId);
//        InputStream inputStream = cmisClient.downloadFile(mainFile.getFileId());

        //写入文件
        // 通过url获取文件
        File f1 = new File(PATH+file.getName());
        // 获取的文件路径
        String url = PATH+file.getName();
        // 取得最后一个/的下标
        int index = url.lastIndexOf("/");
//         返回字符串，截取最后方的文件的名称类型
        String newString = url.substring(index + 1);
//         通过inputStream获取文件
        InputStream inputStream = new FileInputStream(f1);
//         定义一个文件名字进行接收获取文件

        FileOutputStream fileOut
                = new FileOutputStream(new File(PATH + file.getName()));
        byte[] buf = new byte[1024 * 8];
        while (true) {
            int read = 0;
            if (inputStream != null) {
                read = inputStream.read(buf);
            }
            if (read == -1) {
                break;
            }
            fileOut.write(buf, 0, read);
        }
        // 查看文件获取是否成功
        if (fileOut.getFD().valid()) {
            log.info("获取文件保存成功");
        } else {
            log.info("获取文件失败");
        }
        fileOut.flush();

        //转pdf
        String pdfPath = null;
        String filePath = PATH + file.getName();
        String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if ("docx".equals(ext) || "doc".equals(ext)) {
            pdfPath = file.getName().substring(0, file.getName().lastIndexOf(".") + 1) + "pdf";
            PdfUtil.doc2pdf(filePath, pdfPath);//filePaths需要转换的文件位置 pdfPath为存储位置
        }
        if ("pdf".equals(ext)) {
            pdfPath = filePath;
        }

        //在线打开
        try {
            //获取要下载文件的绝对路劲
            File f = new File(pdfPath);
            if (!f.exists()) {
                response.sendError(404, "File not found!");
                return;
            }
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
            byte[] buf1 = new byte[1024];
            int len = 0;

            response.reset(); // 非常重要
            // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
//            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "filename=" + new String(f.getName().getBytes(),
                    "iso8859-1"));
            // 文件名应该编码成UTF-8
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf1)) > 0)
                out.write(buf1, 0, len);
            br.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
