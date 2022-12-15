// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#examples
//
// const input = document.querySelector("#image_uploads");
// const preview = document.querySelector('.preview');
const input_1 = document.querySelector("#file_one");
const preview_1 = document.querySelector('.preview_file_one');
// const add_img_1 = document.querySelector("#add_img_1");
input_1.style.opacity = 0;

const input_2 = document.querySelector("#file_two");
const preview_2 = document.querySelector('.preview_file_two');
input_2.style.opacity = 0;

const input_3 = document.querySelector("#file_three");
const preview_3 = document.querySelector('.preview_file_three');
input_3.style.opacity = 0;

const input_4 = document.querySelector("#file_four");
const preview_4 = document.querySelector('.preview_file_four');
input_4.style.opacity = 0;

const input_5 = document.querySelector("#file_five");
const preview_5 = document.querySelector('.preview_file_five');
input_5.style.opacity = 0;

input_1.addEventListener('change', updateImageDisplay_1);

function updateImageDisplay_1() {
    while(preview_1.firstChild) {
        preview_1.removeChild(preview_1.firstChild);
        // add_img_1.removeChild(add_img_1.lastChild);
    }
    // while(add_img_1.firstChild) {
    //     add_img_1.removeChild(add_img_1.firstChild);
    // }

    const curFiles = input_1.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = 'Файл не загружен.';
        preview_1.appendChild(para);
    } else {
        // const list = document.createElement('ol');
        // preview_1.appendChild(list);

        for (const file of curFiles) {
            const divmain = document.createElement('div');
            preview_1.appendChild(divmain);
            // const listItem = document.createElement('li');
            const para = document.createElement('p');
            if (validFileType(file)) {
                // para.textContent = `File name ${file.name}, file size ${returnFileSize(file.size)}.`;
                // para.textContent = `${file.name}`;
                const image = document.createElement('img');
                image.style.width = "240px";
                image.style.height = "auto";
                image.src = URL.createObjectURL(file);
                // listItem.appendChild(image);
                // listItem.appendChild(para);
                divmain.appendChild(image);
                // divmain.appendChild(para);
            } else {
                para.textContent = `Файл ${file.name}: Не является (PNG, JPG).`;
                // listItem.appendChild(para);
                divmain.appendChild(para);
            }

            // list.appendChild(listItem);
        }
    }
}

// function returnFileSize(number) {
//     if (number < 1024) {
//         return `${number} bytes`;
//     } else if (number >= 1024 && number < 1048576) {
//         return `${(number / 1024).toFixed(1)} KB`;
//     } else if (number >= 1048576) {
//         return `${(number / 1048576).toFixed(1)} MB`;
//     }
// }

// https://developer.mozilla.org/en-US/docs/Web/Media/Formats/Image_types
const fileTypes = [
    "image/apng",
    "image/bmp",
    "image/gif",
    "image/jpeg",
    "image/pjpeg",
    "image/png",
    "image/svg+xml",
    "image/tiff",
    "image/webp",
    "image/x-icon"
];

function validFileType(file) {
    return fileTypes.includes(file.type);
}

input_2.addEventListener('change', updateImageDisplay_2);

function updateImageDisplay_2() {
    while(preview_2.firstChild) {
        preview_2.removeChild(preview_2.firstChild);
    }
    const curFiles = input_2.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = 'Файл не загружен.';
        preview_2.appendChild(para);
    } else {
        for (const file of curFiles) {
            const divmain = document.createElement('div');
            preview_2.appendChild(divmain);
            const para = document.createElement('p');
            if (validFileType(file)) {
                // para.textContent = `${file.name}`;
                const image = document.createElement('img');
                image.style.width = "180px";
                image.style.height = "auto";
                image.src = URL.createObjectURL(file);
                divmain.appendChild(image);
                // divmain.appendChild(para);
            } else {
                para.textContent = `Файл ${file.name}: Не является (PNG, JPG).`;
                divmain.appendChild(para);
            }
        }
    }
}

input_3.addEventListener('change', updateImageDisplay_3);

function updateImageDisplay_3() {
    while(preview_3.firstChild) {
        preview_3.removeChild(preview_3.firstChild);
    }
    const curFiles = input_3.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = 'Файл не загружен.';
        preview_3.appendChild(para);
    } else {
        for (const file of curFiles) {
            const divmain = document.createElement('div');
            preview_3.appendChild(divmain);
            const para = document.createElement('p');
            if (validFileType(file)) {
                // para.textContent = `${file.name}`;
                const image = document.createElement('img');
                image.style.width = "180px";
                image.style.height = "auto";
                image.src = URL.createObjectURL(file);
                divmain.appendChild(image);
                // divmain.appendChild(para);
            } else {
                para.textContent = `Файл ${file.name}: Не является (PNG, JPG).`;
                divmain.appendChild(para);
            }
        }
    }
}

input_4.addEventListener('change', updateImageDisplay_4);

function updateImageDisplay_4() {
    while(preview_4.firstChild) {
        preview_4.removeChild(preview_4.firstChild);
    }
    const curFiles = input_4.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = 'Файл не загружен.';
        preview_4.appendChild(para);
    } else {
        for (const file of curFiles) {
            const divmain = document.createElement('div');
            preview_4.appendChild(divmain);
            const para = document.createElement('p');
            if (validFileType(file)) {
                // para.textContent = `${file.name}`;
                const image = document.createElement('img');
                image.style.width = "180px";
                image.style.height = "auto";
                image.src = URL.createObjectURL(file);
                divmain.appendChild(image);
                // divmain.appendChild(para);
            } else {
                para.textContent = `Файл ${file.name}: Не является (PNG, JPG).`;
                divmain.appendChild(para);
            }
        }
    }
}

input_5.addEventListener('change', updateImageDisplay_5);

function updateImageDisplay_5() {
    while(preview_5.firstChild) {
        preview_5.removeChild(preview_5.firstChild);
    }
    const curFiles = input_5.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = 'Файл не загружен.';
        preview_5.appendChild(para);
    } else {
        for (const file of curFiles) {
            const divmain = document.createElement('div');
            preview_5.appendChild(divmain);
            const para = document.createElement('p');
            if (validFileType(file)) {
                // para.textContent = `${file.name}`;
                const image = document.createElement('img');
                image.style.width = "180px";
                image.style.height = "auto";
                image.src = URL.createObjectURL(file);
                divmain.appendChild(image);
                // divmain.appendChild(para);
            } else {
                para.textContent = `Файл ${file.name}: Не является (PNG, JPG).`;
                divmain.appendChild(para);
            }
        }
    }
}
