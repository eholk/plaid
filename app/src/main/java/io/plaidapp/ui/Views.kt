package io.plaidapp.ui

import android.content.Context
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.RecyclerView
import android.util.Xml
import android.view.View
import android.view.ViewStub
import android.widget.*
import io.plaidapp.R

object Views {
    private fun dpToPixels(context: Context, dp: Int): Int
        = (context.resources.displayMetrics.density * dp + 0.5).toInt()

    fun inflateActivityHome(context: Context): DrawerLayout {
        // Get the XML resources. We'll walk this along as we go so we can pass the right set of XML
        // attributes to each constructor.
        val res = context.resources
        val xml = res.getLayout(R.layout.activity_home)
        val attrs = Xml.asAttributeSet(xml)

        xml.next() // <?xml version="1.0" encoding="utf-8"?>
        xml.next() // copyright header

        println(xml.name)
        val view = DrawerLayout(context, attrs)

        xml.next() // <FrameLayout>
        println(xml.name)
        val frame = FrameLayout(context, attrs)

        xml.next() // <View>
        println(xml.name)
        frame.addView(View(context, attrs))
        xml.next() // </View>

        xml.next() // <RecyclerView>
        println(xml.name)
        frame.addView(RecyclerView(context, attrs))
        xml.next() // </RecyclerView>

        xml.next() // <Toolbar>
        println(xml.name)
        frame.addView(Toolbar(context, attrs))
        xml.next() // </Toolbar>

        xml.next() // <ProgressBar>
        println(xml.name)
        frame.addView(ProgressBar(context, attrs))
        xml.next() // </ProgressBar>

        xml.next() // <ViewStub>
        println(xml.name)
        frame.addView(ViewStub(context, attrs))
        xml.next() // </ViewStub>

        xml.next() // <ViewStub>
        println(xml.name)
        frame.addView(ViewStub(context, attrs))
        xml.next() // </ViewStub>

        xml.next() // <ImageButton>
        println(xml.name)
        frame.addView(ImageButton(context, attrs))
        xml.next() // </ImageButton>

        xml.next() // <ViewStub>
        println(xml.name)
        frame.addView(ViewStub(context, attrs))
        xml.next() // </ViewStub>

        view.addView(frame)
        xml.next() // </FrameLayout>

        xml.next() // <RecyclerView>
        println(xml.name)
        view.addView(RecyclerView(context, attrs))

        // We aren't actually going to read the rest of this parse, so don't call it.
        //xml.next() // </RecyclerView>

        return view
    }
}