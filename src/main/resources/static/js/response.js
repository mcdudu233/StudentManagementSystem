document.write(
    `
        <!-- 模态框提示 -->
        <div aria-hidden="true" aria-labelledby="modalLabel" class="modal fade" id="responseModal" role="dialog" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header justify-content-center">
                        <h5 class="modal-title text-center">提示</h5>
                    </div>
                    <div class="modal-body text-center" id="responseMessage">
                        <!-- 提示内容将在这里动态插入 -->
                    </div>
                    <div class="modal-footer justify-content-center">
                        <button class="btn btn-secondary" data-bs-dismiss="modal">确定</button>
                    </div>
                </div>
            </div>
        </div>
    `
)
let params = new URLSearchParams(window.location.search);
if (params.has('response')) {
    let response = JSON.parse(params.get('response'));
    let responseMessage = document.getElementById("responseMessage");

    if (response.code === 0) {
        responseMessage.innerHTML = `
                <svg xmlns="http://www.w3.org/2000/svg" width="128" height="128" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16" style="color: green;">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
                </svg>
                <p class="mt-3">操作成功！</p>`;
    } else if (response.code === -1) {
        responseMessage.innerHTML = `
                <svg xmlns="http://www.w3.org/2000/svg" width="128" height="128" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16" style="color: red;">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                </svg>
                <p class="mt-3">操作失败！</p>
                <p class="mt-3">${response.msg}</p>`;
    } else {
        responseMessage.innerHTML = `
                <span class="glyphicon glyphicon-ban-circle" style="font-size: 128px; color: red;"></span>
                <p class="mt-3">未知错误！</p>
                <p class="mt-3">${response.msg}</p>`;
    }

    // 显示模态框
    let modal = new bootstrap.Modal(document.getElementById("responseModal"));
    modal.show();
}