package com.example.arassignment

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Anchor
import com.google.ar.core.Config
import com.google.ar.core.Plane
import io.github.sceneview.ar.ARSceneView
import io.github.sceneview.ar.node.AnchorNode
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ARActivity : AppCompatActivity() {

    private lateinit var arSceneView: ARSceneView
    private lateinit var modelLoader: ModelLoader
    private var placed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aractivity)

        arSceneView = findViewById(R.id.arSceneView)
        modelLoader = ModelLoader(arSceneView.engine,this)

        arSceneView.configureSession { _, config ->
            config.planeFindingMode = Config.PlaneFindingMode.HORIZONTAL

            config.lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR
        }

        arSceneView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP && !placed) {
                arSceneView.frame
                    ?.hitTest(event)
                    ?.firstOrNull { it.trackable is Plane }
                    ?.createAnchor()
                    ?.let { anchor ->
                        placeModel(anchor)
                        placed = true
                    }
            }
            true
        }
    }

    private fun placeModel(anchor: Anchor) {
        val anchorNode = AnchorNode(arSceneView.engine, anchor)
        arSceneView.addChildNode(anchorNode)

        CoroutineScope(Dispatchers.Main).launch {
            val modelInstance = modelLoader.loadModelInstance(
                fileLocation = "models/cube_bricks.glb"
            )

            if (modelInstance != null) {
                val modelNode = ModelNode(modelInstance,true,0.2f,Position(0.0f))
                anchorNode.addChildNode(modelNode)
            }
        }
    }
}