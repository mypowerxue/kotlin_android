package com.syx.main.activity.kotlin.model.bean

class MainBean {

    /**
     * msg : 操作成功
     * ext :
     * code : 200
     * data : {"totalRow":18,"pageNumber":3,"firstPage":false,"lastPage":true,"totalPage":3,"pageSize":8,"list":[{"giftName":"别墅","giftPrice":334400,"giftPic":"http://art.nos-eastchina1.126.net/cms1521085644517.jpg","id":34,"charmValue":334400},{"giftName":"水晶鞋","giftPrice":1990,"giftPic":"http://hd.connxun.com/whisper/img/gift/100/shuijingxie.png","id":22,"charmValue":1990}]}
     */

    private var msg: String? = null
    private var ext: String? = null
    private var code: String? = null
    private var data: DataBean? = null

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }

    fun getExt(): String? {
        return ext
    }

    fun setExt(ext: String) {
        this.ext = ext
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String) {
        this.code = code
    }

    fun getData(): DataBean? {
        return data
    }

    fun setData(data: DataBean) {
        this.data = data
    }

    class DataBean {
        /**
         * totalRow : 18
         * pageNumber : 3
         * firstPage : false
         * lastPage : true
         * totalPage : 3
         * pageSize : 8
         * list : [{"giftName":"别墅","giftPrice":334400,"giftPic":"http://art.nos-eastchina1.126.net/cms1521085644517.jpg","id":34,"charmValue":334400},{"giftName":"水晶鞋","giftPrice":1990,"giftPic":"http://hd.connxun.com/whisper/img/gift/100/shuijingxie.png","id":22,"charmValue":1990}]
         */

        var totalRow: Int = 0
        var pageNumber: Int = 0
        var isFirstPage: Boolean = false
        var isLastPage: Boolean = false
        var totalPage: Int = 0
        var pageSize: Int = 0
        var list: List<ListBean>? = null

        class ListBean {
            /**
             * giftName : 别墅
             * giftPrice : 334400
             * giftPic : http://art.nos-eastchina1.126.net/cms1521085644517.jpg
             * id : 34
             * charmValue : 334400
             */

            var giftName: String? = null
            var giftPrice: Int = 0
            var giftPic: String? = null
            var id: Int = 0
            var charmValue: Int = 0
        }
    }

}
