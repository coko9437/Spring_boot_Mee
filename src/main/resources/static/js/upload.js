// 앞단의 게시글작성시
    // 전달할 준비물... 1) 게시글, 2)첨부된이미지 ==> 객체에 담고,
    // 부트 서버에 전달
    // -> /upload , Post형식으로 전달.
    // axios를 이용해서 비동기통신 이용하기.

//이미지 업로드 기능
async function uploadToServer (formObj) {
    console.log("uploadToServer, axios 작업중.")
    console.log(formObj)

    const response = await axios({ // 진동벨이라 생각하면됨.
        method : 'post', // 키와 값 형태
        url : '/upload',
        data : formObj,
        headers : {
            'Content-Type' : 'multipart/form-data' // 둘다 정해진 이름임 변경불가.

        },
    });
    return response.data
}

//이미지 삭제 기능
async function removeFileToServer(uuid, fileName) { // uuid : 내용
    const response = await axios.delete(`/remove/${uuid}_${fileName}`)
    return response.data
}