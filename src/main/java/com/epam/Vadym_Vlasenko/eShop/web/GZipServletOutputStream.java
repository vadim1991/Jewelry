package com.epam.Vadym_Vlasenko.eShop.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public class GZipServletOutputStream extends ServletOutputStream {
    private GZIPOutputStream gzipOutputStream = null;

    public GZipServletOutputStream(OutputStream output)
            throws IOException {
        super();
        this.gzipOutputStream = new GZIPOutputStream(output);
    }

    @Override
    public void close() throws IOException {
        this.gzipOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        this.gzipOutputStream.flush();
    }

    @Override
    public void write(byte b[]) throws IOException {
        this.gzipOutputStream.write(b);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        this.gzipOutputStream.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        this.gzipOutputStream.write(b);
    }

    @Override
    public boolean isReady() {
        return this.isReady();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        this.setWriteListener(writeListener);
    }
}
