const funcGetProjects = () => {
    const url = '/project/list';
    const getting = $.get(url);
    getting.done((data) => {
        if(data.ok){
            funcAppendProjectItem(data.list);
        }else{
            showMessage('Error', data.msg);
        }
    })

    getting.fail((e) => {
        console.log('error', e);
    })
}

const funcAppendProjectItem = (data) => {
    if(data == null || data.size == 0){
        return;
    }
    $('#projectList').empty();
    let _tr = ``;
    $.each(data, (idx,item) => {
        _tr = `
                <tr data-seq = ${item.seq}>
                    <td>${idx + 1}</td>
                    <td>${item.projectName}</td>
                    <td>${item.content}</td>                
                    <td>${item.projectStartDt != null ? item.projectStartDt : ''} ~ ${item.projectEndDt != null ? item.projectEndDt : ''}</td>
                </tr>`;

        $('#projectList').append(_tr);
    })

}

const evtClickTd = (e) => {
    e.preventDefault();
    const _seq = $(e.currentTarget).data('seq');
    const url = '/project/get/' + _seq;
    const getting = $.get(url);
    getting.done((data) => {
        if(data.ok){
            funcGetProjectDetail(data.object);
        }else{
            showMessage('Error', data.msg);
        }
    })
    getting.fail((e) => {
        console.log('Error', e);
    })
}

const funcGetProjectDetail = (data) => {
    $('#projectModalForm')[0].reset();
    $('#projectModalTitle').text('Project 수정');
    $('#method').val('update');
    $('#seq').val(data.seq);
    $('#projectName').val(data.projectName);
    $('#content').html(data.content);
    $('#projectStartDtStr').val(data.projectStartDt);
    $('#projectEndDtStr').val(data.projectEndDt);
    $('#projectModal').modal('show');
}

const evtClickProjectInsert = (e) => {
    e.preventDefault();
    $('#projectModalTitle').text('Project 추가');
    $('#projectModalForm')[0].reset();
    $('#content').html('');
    $('#method').val('insert');
    $('#projectModal').modal('show');
}


const evtSubmitProjectModalForm = (e) => {
    e.preventDefault();
    const method = $('#method').val();
    if(method == 'insert'){
        funcInsertProject();
    }else{
        funcUpdateProject();
    }
}

const funcInsertProject = () => {
    const url = '/project/insert';
    const posting  = $.post(url, $('#projectModalForm').serialize());
    posting.done((data) => {
        if(data.ok){
            $('#projectModal').modal('hide');
            showMessage('Success' , data.msg);
        }else{
            showMessage('Error', data.msg);
        }
    })
    posting.fail((e) => {
        showMessage('Error', '통신 에러, 관리자에게 문의바랍니다');
    })
}


const funcUpdateProject = () => {
    const url = '/project/update';
    const posting = $.post(url, $('#projectModalForm').serialize());
    posting.done((data) => {
        if(data.ok){

        }else{
            showMessage('Error', data.msg);
        }
    })
    posting.fail((e) => {
        showMessage('Error', '통신 에러, 관리자에게 문의바랍니다');
    })
}
$(() => {
    funcGetProjects();

    $('#projectList').on('click', 'tr', evtClickTd);
    $('#projectInsertBtn').on('click', evtClickProjectInsert);
    $('#projectModalForm').on('submit', evtSubmitProjectModalForm)
})