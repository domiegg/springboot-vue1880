const base = {
    get() {
        return {
            url : "http://localhost:8080/sifangcaidingzhishangmenfuwu/",
            name: "sifangcaidingzhishangmenfuwu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/sifangcaidingzhishangmenfuwu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "私房菜定制上门服务系统"
        } 
    }
}
export default base
