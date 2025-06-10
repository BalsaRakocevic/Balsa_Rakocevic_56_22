package me.fit.resource;

import org.jboss.resteasy.reactive.RestForm;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.multipart.FileUpload;




public class FileForm {
    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public String fileName;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public FileUpload file;
}