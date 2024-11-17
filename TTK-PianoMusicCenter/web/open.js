function openNav(){
    document.getElementById("mySidenav").style.width='310px'
    document.getElementById("mySidenav").style.pointerEvents = 'auto';
    document.querySelector(".container").style.pointerEvents = 'none';
    document.querySelector(".container").style.opacity = '0.5';
    document.getElementById("mySidenav").style.opacity = ''; 
    const elol = document.getElementById("mySidenav");



    // Sử dụng sự kiện mousedown và mouseup để kiểm tra khi nào người dùng nhấn chuột và khi nào họ nhả ra
    document.addEventListener('mousedown', function(event) {
        if (event.target !== elol) {
            closeNav(); // Ẩn phần tử <ol> nếu không nhấn vào nó
        }
    });

    elol.addEventListener('mousedown', function(event) {
        event.stopPropagation(); // Ngăn chặn sự kiện mousedown lan ra các phần tử khác
    });
    elol.addEventListener('mouseup', function(event) {
        elol.style.display = 'block'; // Hiển thị phần tử <ol> khi nhấn chuột lên
    });

}
function closeNav(){
    document.getElementById("mySidenav").style.width='0px'
    document.querySelector(".container").style.pointerEvents = 'auto';
    document.querySelector(".container").style.opacity = '';
}
