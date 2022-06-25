export default function () {
    console.info('default')
};

export function each() {
    console.info('each');
}

export {each as forEach}
