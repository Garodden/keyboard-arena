const createButton = document.getElementById('create-arena-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch(`/newArena`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body : JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            }),
        }).then(() => {
            alert('등록 완료되었습니다');
            location.replace("/arenas");
        })
    })
}