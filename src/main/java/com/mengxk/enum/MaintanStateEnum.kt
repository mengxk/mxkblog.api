package com.mengxk.enum

/**
 * Created by mengxk on 2018/8/9.
 */
public enum class MaintanStateEnum {
    non_assign,         //已创建，待分配
    non_accept,         //已分配，待接收
    maintaining,        //已接收，服务中
    non_confirm,        //完成服务，待确认
    non_userConfirm,    //已确认，待客户确认
    non_feedback,       //客户已确认，待回访
    feedbacked,         //回访完成，流程结束
    goback              //退回分配，此为动作，为了方便编码，不对应服务状态

}