package com.jxfh.auciton.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public final class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);//日志记录

    private static final Map<String, Integer> FILE_TYPE_MAP = new HashMap<String, Integer>();//文件类型

    private static final Map<Integer, String> FILE_TYPE_DIR_MAP = new HashMap<Integer, String>();//文件类型存储目录

    private static final String FILE_SEPARATOR = File.separator;//系统的路径分隔符

    private static final String EXCEPTION_SEPARATOR = ".";//扩展名分隔符

    private static final String WEB_SEPARATOR = "/";//WEB路径分隔符

    public static final int FILE_TYPE_IMG = 1;//1图片

    public static final String FILE_TYPE_IMG_DIR = "images";//图片文件夹名称

    public static final int FILE_TYPE_VIDEO = 2;//2视频

    public static final String FILE_TYPE_VIDEO_DIR = "videos";//视频文件夹名称

    public static final String FILE_TYPE_OTHER_DIR = "other";//其它类型文件夹名称

    private static String storagePath = null;//区分不同的系统,模版存储路径不同

    private static final String LINUX_SOURCE_ROOT = "/disk/sdb/project_test/product_resource";//LINUX 资源根目录

    private static final String WIN_SOURCE_ROOT = "D:\\project_test\\product_resource";//windows 资源根目录

    static {
        distinguishOSPath();//获取系统属性,判断系统类型,存储路径不同
        createStorageDirectory();//检查并创建资源根路径
        initSimpleFileType();//初始化文件扩展名与业务类型map
        initFileTypeDirMap();//初始化不同类型的文件存储到不同的目录
    }

    /**
     * @duthor: xingyongchun
     * @description: 初始化不同类型的文件存储到不同的目录
     * @date: 2018/4/18
     * @return: void
     */
    private static void initFileTypeDirMap() {
        FILE_TYPE_DIR_MAP.put(FILE_TYPE_IMG, FILE_TYPE_IMG_DIR);
        FILE_TYPE_DIR_MAP.put(FILE_TYPE_VIDEO, FILE_TYPE_VIDEO_DIR);
    }


    /**
     * @duthor: xingyongchun
     * @description: 初始化文件扩展名与业务类型map
     * @date: 2018/4/17
     * @return: void
     */
    private static void initSimpleFileType() {
        FILE_TYPE_MAP.put("BMP", FILE_TYPE_IMG);
        FILE_TYPE_MAP.put("GIF", FILE_TYPE_IMG);
        FILE_TYPE_MAP.put("JPG", FILE_TYPE_IMG);
        FILE_TYPE_MAP.put("PNG", FILE_TYPE_IMG);
        FILE_TYPE_MAP.put("JPEG", FILE_TYPE_IMG);
      /*  FILE_TYPE_MAP.put("MP4", FILE_TYPE_VIDEO);
        FILE_TYPE_MAP.put("FLV", FILE_TYPE_VIDEO);*/
    }

    //获取系统属性,判断系统类型,存储路径不同
    private static void distinguishOSPath() {
        String osName = System.getProperty("os.name");
        if (StringUtils.isNotBlank(osName)) {
            String osNameLower = osName.toLowerCase();
            if (osNameLower.contains("linux") || osNameLower.contains("lin")) {
                storagePath = LINUX_SOURCE_ROOT;//linux存储路径
            } else if (osNameLower.contains("windows") || osNameLower.contains("win")) {
                storagePath = WIN_SOURCE_ROOT;//windows存贮路径
            }
        }
    }

    //检查并创建资源根路径
    private static void createStorageDirectory() {
        if (StringUtils.isNotBlank(storagePath)) {
            try {
                FileUtils.forceMkdir(new File(storagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @duthor: xingyongchun
     * @description: 在跟路径下面创建子一级文件夹
     * @param: childrenDir
     * @date: 2018/4/4
     * @return: boolean
     */
    public static String mkdirChildren(String childrenDir) {
        String dirs = storagePath + FILE_SEPARATOR + childrenDir;
        try {
            FileUtils.forceMkdir(new File(dirs));
            return dirs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @duthor: xingyongchun
     * @description: 将文件改名为UUID格式
     * @param: filenameExtension
     * @date: 2018/4/4
     * @return: java.lang.String
     */
    public static String createNewFileName(String filenameExtension) {
        return UUID.randomUUID().toString().replaceAll("-", "") + EXCEPTION_SEPARATOR
                + filenameExtension;
    }

    /**
     * @duthor: xingyongchun
     * @description: 上传文件
     * @param: inputStream
     * @param: newFileName
     * @date: 2018/4/4
     * @return: java.lang.String
     */
    public static String uploadFile(InputStream inputStream, String newFileName, int fileType) {
        String dateYMDString = DateTimeUtil.getDateYMDString(new Date());//创建年月日为名字的子文件夹
        String fileTypeDir = getFileTypeDir(fileType);//文件类型问价夹名称
        String children = mkdirChildren(fileTypeDir + FILE_SEPARATOR + dateYMDString);
        if (StringUtils.isNotBlank(children)) {
            try {
                FileUtils.copyInputStreamToFile(inputStream, new File(children + FILE_SEPARATOR + newFileName));
                return fileTypeDir + WEB_SEPARATOR + dateYMDString + WEB_SEPARATOR + newFileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @duthor: xingyongchun
     * @description: 文件流的MD5值
     * @param: data
     * @date: 2018/4/4
     * @return: java.lang.String
     */
    public static String fileMD5hashCode(InputStream data) {
        String md5Hex = null;
        try {
            md5Hex = DigestUtils.md5Hex(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return md5Hex;
    }

    /**
     * @duthor: xingyongchun
     * @description: 根据扩展名获取文件业务类型
     * @param: fileExtension
     * @date: 2018/4/17
     * @return: java.lang.Integer
     */
    public static Integer getFileType(String fileExtension) {
        if (StringUtils.isNotBlank(fileExtension)) {
            Integer type = FILE_TYPE_MAP.get(fileExtension.toUpperCase());
            return type;
        }
        return null;
    }

    /**
     * @duthor: xingyongchun
     * @description: 获取存储绝对路径
     * @date: 2018/4/18
     * @return: java.lang.String
     */
    public static String getImagesStoragePath() {
        return storagePath + FILE_SEPARATOR + FILE_TYPE_IMG_DIR + FILE_SEPARATOR;
    }

    public static String getVideosStoragePath() {
        return storagePath + FILE_SEPARATOR + FILE_TYPE_VIDEO_DIR + FILE_SEPARATOR;
    }

    /**
     * @duthor: xingyongchun
     * @description: 根据文件类型获取文件存储名称
     * @param: fileType
     * @date: 2018/4/18
     * @return: java.lang.String
     */
    public static String getFileTypeDir(int fileType) {
        String s = FILE_TYPE_DIR_MAP.get(fileType);
        if (StringUtils.isNotBlank(s)) {
            return s;
        } else {
            return FILE_TYPE_OTHER_DIR;
        }
    }

    /**
     * @author: mahuangfei
     * @description: 根据文件夹路径获取所有文件名
     * @param: fileDir
     * @date: 2019/6/24
     * @return: List
     */
    private static List<File> getAllFiles(String fileDir) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }

        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                getAllFiles(f.getAbsolutePath());
            }
        }
        return fileList;
    }
    private static List<String> getAllFilesName(String fileDir) {
        List<String> fileList = new ArrayList<String>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }

        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f.getName());
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                getAllFiles(f.getAbsolutePath());
            }
        }
		/*for (File f1 : fileList) {
			System.out.println(f1.getName());
		}*/
        return fileList;
    }

    //获取视频目录下的文件名
    public static List<String> getAllVideos() {
        return getAllFilesName(storagePath + "\\" + FILE_TYPE_VIDEO_DIR);
    }

    /**
     * @author: mahuangfei
     * @description: 根据文件夹路径获取第一层子文件夹名
     * @param: fileDir
     * @date: 2019/6/26
     * @return: List
     */
    private static List<String> getDir(String fileDir) {
        List<String> fileList = new ArrayList<String>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }
        for (File f : files) {
            if (!f.isFile()) {
                fileList.add(f.getName());
            }
        }
        return fileList;
    }

    /**
     * @author: mahuangfei
     * @description: 根据文件夹路径获取第二层子文件夹名+第一层拼接
     * @param: fileDir
     * @date: 2019/6/26
     * @return: List
     */
    private static List<String> getSeDir(String fileDir) {
        List<String> firstDirList = getDir(fileDir);
        List<String> dirList = new ArrayList<String>();
        if (firstDirList == null) {
            return null;
        }
        for (String firstDirName : firstDirList) {
            List<String> seDirLsit = getDir(fileDir + "/" + firstDirName);
            if (seDirLsit == null) {
                dirList.add(firstDirName + "/");
            } else {
                for (String seDirName : seDirLsit) {
                    dirList.add(firstDirName + "/" + seDirName);
                }
            }
        }
        return dirList;
    }

    public static String getStoragePath(){
        return storagePath;
    }
    public static List<String> getDirList (String fileDir) {
        return getSeDir(fileDir);
    }
    public static List<File> getVideos(String dir){
        return getAllFiles (dir);
    }

}
