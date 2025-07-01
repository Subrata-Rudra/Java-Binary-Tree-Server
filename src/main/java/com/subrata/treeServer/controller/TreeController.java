package com.subrata.treeServer.controller;

import com.subrata.treeServer.dto.BuildTreeTraversalResponseDto;
import com.subrata.treeServer.dto.TreeNodeDto;
import com.subrata.treeServer.helper.TreeViewer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.subrata.treeServer.dto.BuildTreeRequestDto;
import com.subrata.treeServer.helper.TreeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TreeController {
    @GetMapping(value = "/", produces = "text/html")
    public String test() {
        return """
                    <!DOC TYPE html>
                    <html>
                    <head>
                        <title>Java🍵 Binary Tree🌳 Server</title>
                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f4f6f9;
                                padding: 40px;
                                color: #333;
                            }
                            h1 {
                                color: #2e8b57;
                            }
                            code {
                                background-color: #eee;
                                padding: 6px 10px;
                                display: block;
                                margin: 10px 0;
                                border-left: 4px solid #2e8b57;
                                font-size: 14px;
                                color: #000;
                            }
                            .container {
                                max-width: 700px;
                                margin: auto;
                                background-color: #fff;
                                padding: 30px;
                                border-radius: 10px;
                                box-shadow: 0 4px 10px rgba(0,0,0,0.1);
                            }
                            b {
                                color: #007acc;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <h1>Java🍵 Binary Tree🌳 Server is LIVE 🟢</h1>
                            <p>Send a <b>POST</b> request with data in this JSON format:</p>
                            <code>{ "elements": [1, 2, 3, null, 5, 6, null] }</code>
                            <p>Use the following endpoints:</p>
                            <ul>
                                <li><b>/buildAndGetTree</b> — returns the whole tree in JSON format</li>
                                <li><b>/buildAndTraverseTree</b> — returns the root, inorder, preorder, postorder, and level order traversal of the tree</li>
                            </ul>
                        </div>
                    </body>
                    </html>
                """;
    }

    @PostMapping("/buildAndGetTree")
    public Map<String, Object> buildAndGetTree(@RequestBody BuildTreeRequestDto request) {
        TreeNodeDto tree = TreeBuilder.levelOrderBuild(request.getElements());
        Map<String, Object> response = new HashMap<>();
        if (tree == null) {
            response.put("message", "Tree could not be built. Input list is null or empty.");
        } else {
            response.put("tree", tree);
        }
        return response;
    }

    @PostMapping("/buildAndTraverseTree")
    public BuildTreeTraversalResponseDto buildAndTraverseTree(@RequestBody BuildTreeRequestDto request) {
        TreeNodeDto root = TreeBuilder.levelOrderBuild(request.getElements());
        ArrayList<Integer> inorderWiseView = TreeViewer.inorderView(root);
        ArrayList<Integer> preorderWiseView = TreeViewer.preorderView(root);
        ArrayList<Integer> postorderWiseView = TreeViewer.postorderView(root);
        HashMap<Integer, ArrayList<Integer>> levelorderWiseView = TreeViewer.levelOrderView(root);
        BuildTreeTraversalResponseDto response = new BuildTreeTraversalResponseDto();
        if (root != null) {
            response.setRoot(root.getData());
        }
        response.setInorder(inorderWiseView);
        response.setPreorder(preorderWiseView);
        response.setPostorder(postorderWiseView);
        response.setLevelorder(levelorderWiseView);
        return response;
    }
}
