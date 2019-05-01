
package web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import ua.univer.photostock.model.OriginalImage;
import ua.univer.photostock.service.PhotoService;
import web.util.UrlExtractorUtils;

@WebServlet(urlPatterns = "/download/*", loadOnStartup = 1)
public class DownloadPhotoController extends HttpServlet {

    @EJB
    private PhotoService photoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long photoId = Long.parseLong(UrlExtractorUtils.getPathVariableValue(
                req.getRequestURI(), "/download/", ".jpg"));
        OriginalImage originalImage = photoService
                .downloadOriginalImage(photoId);

        resp.setHeader("Content-Disposition",
                "attachment; filename=" + originalImage.getName());
        resp.setContentType(
                getServletContext().getMimeType(originalImage.getName()));
        resp.setContentLengthLong(originalImage.getSize());
        try (InputStream in = originalImage.getIn();
                OutputStream out = resp.getOutputStream()) {
            IOUtils.copyLarge(in, out);
        }
    }
}
