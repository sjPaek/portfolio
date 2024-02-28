const funcGetProjects = async () => {
    const url = '/project/list';
    const result = await $.get(url);
    const {ok, msg, list} = result;

    try{
        if(ok){
            console.log(list);
            // showMessage("Success", "정상적으로 조회되었습니다");
        }else{
            showMessage("Error", "오류");
        }
    }catch (e) {
        showMessage("Error", "통신 오류 관리자에게 연락바랍니다")
    }
}

const funcMakeProjectItem = (data) => {
    let item = '';
    $.each(data,function(idx, item) {
        item = `<div class="col-md-4 ">
                    <div class="box ">
                        <div class="img-box">
                            <img src="img/s1.png" alt="">
                        </div>
                        <div class="detail-box">
                            <h5>
                                ${item.projectName}
                            </h5>
                            <p>
                                ${item.content}  <br>
                                ${item.projectStartDt} ~ ${item.projectEndDt}
                            </p>
                            <a href="/project/detail/${item.seq}">
                                Read More
                            </a>
                        </div>
                    </div>
                </div>`;

        //item append
    })
}


$(async () => {
    await funcGetProjects();
})