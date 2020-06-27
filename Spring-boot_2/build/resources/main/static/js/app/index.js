var index = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },

    save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    },
    delete: function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    }
};

index.init();

/*
window.loacation.href = '/'
글 등록이 성공하면 메인페이지로 이동한다.

첫 줄에 var index = {...} 을 선언한 이유
위 js가 존재하고, a.js를 추가로 선언했다 가정하자.
a.js는 a.js만의 init과 save function이 있다고 가정하자.
브라우저의 스코프는 공용공간으로 쓰인다. 때문에 나중에 로딩된 js의 init, save가 먼저 로딩된 js의 function을 덮어쓰게 된다.

여러 사람이 참여하는 프로젝트에서는 중복된 함수 이름은 자주 발생한다. 모든 function이름을 확인하면서 만들 순 없다.
따라서 위와 같은 문제를 사전에 방지하기 위해 index.js만의 유효범위를 만들어 사용한다.

방법은 var index란 객체를 만들어 해당 객체에서 필요한 모든 function을 선언하는 것이다.
이렇게 하면 index 객체 안에서만 function이 유효하기 때문에 다른 JS와 겹칠 위험이 사라진다.

*/