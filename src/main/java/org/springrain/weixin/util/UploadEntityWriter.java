package org.springrain.weixin.util;

import com.ning.http.client.Request;

import java.io.*;

/**
 * 功能描述：
 *
 * @author <a href="mailto:guohua@ucweb.com">郭华</a>
 * @version 1.0.0
 * @since 1.0.0
 * create on: 2014/8/20 11:45
 */
public class UploadEntityWriter implements Request.EntityWriter {
    byte[] end_data;
    File file;

    public UploadEntityWriter(byte[] end_data, File file) {
        this.end_data = end_data;
        this.file = file;
    }

    @Override
    public void writeEntity(OutputStream out) throws IOException {
        String BOUNDARY = "----WebKitFormBoundaryiDGnV9zdZA1eM1yL"; // 定义数据分隔线
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n");
        sb.append("Content-Type:application/octet-stream\r\n\r\n");
        byte[] data = sb.toString().getBytes();
        out.write(data);
        DataInputStream fs = new DataInputStream(new FileInputStream(file));
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while ((bytes = fs.read(bufferOut)) != -1) {
            out.write(bufferOut, 0, bytes);
        }
        out.write("\r\n".getBytes()); //多个文件时，二个文件之间加入这个
        fs.close();
        out.write(end_data);
        out.flush();
        out.close();
    }
}
