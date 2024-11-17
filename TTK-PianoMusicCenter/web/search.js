const elInput = document.getElementById("search");
const elol = document.getElementById("list_results");



    // Sử dụng sự kiện mousedown và mouseup để kiểm tra khi nào người dùng nhấn chuột và khi nào họ nhả ra

    document.addEventListener('mousedown', function(event) {
        if (event.target !== elInput) {
            elol.style.display = 'none'; // Ẩn phần tử <ol> nếu không nhấn vào nó
        }
    });
    elInput.addEventListener('mousedown', function(event) {
        event.stopPropagation(); // Ngăn chặn sự kiện mousedown lan ra các phần tử khác
    });
    elInput.addEventListener('mouseup', function(event) {
        elol.style.display = 'block'; // Hiển thị phần tử <ol> khi nhấn chuột lên
    });