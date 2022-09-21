package com.github.jeffery.protect;

/**
 * @author mxlei
 * @date 2022/9/21
 */
public class ApkProtectExtension {
    /**
     * 腾讯云secretId
     */
    private String tencentCloudSecretId = "AKIDGLBk36tPedLmwsZz93h5C2cPvBBvPcYE";

    /**
     * 腾讯云secretKey
     */
    private String tencentCloudSecretKey = "RbT5QUIq8BxShfMmwpRmqeBRQ9bnlTu4";

    /**
     * 腾讯COS bucket名称
     */
    private String tencentCloudCosBucket = "gradle-1300412012";

    /**
     * 腾讯COS region区域名称
     */
    private String tencentCloudCosRegion = "ap-guangzhou";

    /**
     * 加固任务完成后自动删除cos中的文件
     */
    private boolean tencentCloudCosDeleteFileAfterTask = true;

    public String getTencentCloudSecretId() {
        return tencentCloudSecretId;
    }

    public void setTencentCloudSecretId(String tencentCloudSecretId) {
        this.tencentCloudSecretId = tencentCloudSecretId;
    }

    public String getTencentCloudSecretKey() {
        return tencentCloudSecretKey;
    }

    public void setTencentCloudSecretKey(String tencentCloudSecretKey) {
        this.tencentCloudSecretKey = tencentCloudSecretKey;
    }

    public String getTencentCloudCosBucket() {
        return tencentCloudCosBucket;
    }

    public void setTencentCloudCosBucket(String tencentCloudCosBucket) {
        this.tencentCloudCosBucket = tencentCloudCosBucket;
    }

    public String getTencentCloudCosRegion() {
        return tencentCloudCosRegion;
    }

    public void setTencentCloudCosRegion(String tencentCloudCosRegion) {
        this.tencentCloudCosRegion = tencentCloudCosRegion;
    }

    public boolean isTencentCloudCosDeleteFileAfterTask() {
        return tencentCloudCosDeleteFileAfterTask;
    }

    public void setTencentCloudCosDeleteFileAfterTask(boolean tencentCloudCosDeleteFileAfterTask) {
        this.tencentCloudCosDeleteFileAfterTask = tencentCloudCosDeleteFileAfterTask;
    }
}
