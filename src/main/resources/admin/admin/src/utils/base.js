const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot2595688s/",
            name: "springboot2595688s",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot2595688s/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "林业资源管理系统设计与实现"
        } 
    }
}
export default base
