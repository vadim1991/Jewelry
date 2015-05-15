package com.epam.Vadym_Vlasenko.eShop.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public class GZipServletResponseWrapper extends HttpServletResponseWrapper {

    private GZipServletOutputStream gzipOutputStream = null;
    private PrintWriter printWriter = null;

    public GZipServletResponseWrapper(HttpServletResponse response)
            throws IOException {
        super(response);
    }

    public void close() throws IOException {
        if (this.printWriter != null) {
            this.printWriter.close();
        }
        if (this.gzipOutputStream != null) {
            this.gzipOutputStream.close();
        }
    }

    @Override
    public void flushBuffer() throws IOException {
        if (this.printWriter != null) {
            this.printWriter.flush();
        }
        IOException exceptionOutputStream = null;
        try {
            if (this.gzipOutputStream != null) {
                this.gzipOutputStream.flush();
            }
        } catch (IOException e) {
            exceptionOutputStream = e;
        }
        IOException exception = null;
        try {
            super.flushBuffer();
        } catch (IOException e) {
            exception = e;
        }
        if (exceptionOutputStream != null) throw exceptionOutputStream;
        if (exception != null) throw exception;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.printWriter != null) {
            throw new IllegalStateException("PrintWriter obtained already - cannot get OutputStream");
        }
        if (this.gzipOutputStream == null) {
            this.gzipOutputStream = new GZipServletOutputStream(
                    getResponse().getOutputStream());
        }
        return this.gzipOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (this.printWriter == null && this.gzipOutputStream != null) {
            throw new IllegalStateException("OutputStream obtained already - cannot get PrintWriter");
        }
        if (this.printWriter == null) {
            this.gzipOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
            this.printWriter = new PrintWriter(new OutputStreamWriter(
                    this.gzipOutputStream, getResponse().getCharacterEncoding()));
        }
        return this.printWriter;
    }


    @Override
    public void setContentLength(int len) {

    }
}
