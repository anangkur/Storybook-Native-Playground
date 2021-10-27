const { generateStories } = require("@storybook/native");
const { pascalCase } = require("change-case");

const components = [
    {
        name: "button",
    },
];

const promises = components.map(async (component) => {
    return generateStories({
        category: pascalCase(component.name),
        filePath: `./stories/${component.name}.stories.jsx`,
        apiKey: "w2nbfjgwbaf8bvh0mn0fjz20q0",
        platform: "android",
        stories: [
            {
                name: "Example",
                appParams: {
                    component: component.name
                },
            }
        ],
        controls: component.control ? Object.entries(component.control) : undefined,
        deepLinkUrl: "smpgn://ui-components"
    });
});

Promise.all(promises).catch((err) => {
    console.error(err);
    process.exit(1);
});