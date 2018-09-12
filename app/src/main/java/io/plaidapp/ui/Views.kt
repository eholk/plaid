package io.plaidapp.ui

import android.content.Context
import android.content.res.XmlResourceParser
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Xml
import android.view.LayoutInflater
import android.view.View
import android.view.ViewStub
import android.widget.*
import io.plaidapp.R
import org.xmlpull.v1.XmlPullParser

private fun XmlPullParser.logState() {
    println("  ".repeat(this.depth) + XmlPullParser.TYPES[this.eventType] + ": " + this.name)
}

private fun XmlResourceParser.nextLog() {
    this.next()
    this.logState()
}

object Views {
    private fun dpToPixels(context: Context, dp: Int): Int
        = (context.resources.displayMetrics.density * dp + 0.5).toInt()

    fun inflateActivityHome(context: Context): DrawerLayout {
        // Get the XML resources. We'll walk this along as we go so we can pass the right set of XML
        // attributes to each constructor.
        val res = context.resources
        val xml = res.getLayout(R.layout.activity_home)

        xml.logState()

        xml.nextLog() // <?xml version="1.0" encoding="utf-8"?>

        xml.nextLog() // <DrawerLayout>
        val attrs = Xml.asAttributeSet(xml)
//        println(xml.name + " " + attrs.getAttributeName(0) + "=" + attrs.getAttributeValue(0) + " :: " + R.id.drawer)
        val view = DrawerLayout(context, attrs)

        xml.nextLog() // <FrameLayout>
//        println(xml.name + " " + attrs.idAttribute)
        val frame = FrameLayout(context, attrs)
        val frame_params = view.generateLayoutParams(attrs);

        xml.nextLog() // <View>
//        println(xml.name + " " + attrs.getAttributeName(0) + "=" + attrs.getAttributeValue(0) + " :: " + R.id.status_bar_background)
        var layout_params = frame.generateLayoutParams(attrs)
        frame.addView(View(context, attrs), layout_params)
        xml.nextLog() // </View>

        xml.nextLog() // <RecyclerView>
//        println(xml.name + " " + attrs.getAttributeName(1) + "=" + attrs.getAttributeValue(1) + " :: " + R.id.grid)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(RecyclerView(context, attrs), layout_params)
        xml.nextLog() // </RecyclerView>

        xml.nextLog() // <Toolbar>
//        println(xml.name + " " + attrs.getAttributeName(0) + "=" + attrs.getAttributeValue(0) + " :: " + R.id.toolbar)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(Toolbar(context, attrs), layout_params)
        xml.nextLog() // </Toolbar>

        xml.nextLog() // <ProgressBar>
//        println(xml.name + " " + attrs.getAttributeName(1) + "=" + attrs.getAttributeValue(1) + " :: " + android.R.id.empty)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(ProgressBar(context, attrs), layout_params)
        xml.nextLog() // </ProgressBar>

        xml.nextLog() // <ViewStub>
//        println(xml.name + " " + attrs.getAttributeName(1) + "=" + attrs.getAttributeValue(1) + " :: " + R.id.stub_no_filters)
        var stub = ViewStub(context, attrs)
        val inflater = LayoutInflater.from(context)
        //stub.layoutInflater = inflater.cloneInContext(context)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(stub, layout_params)
        xml.nextLog() // </ViewStub>

        xml.nextLog() // <ViewStub>
        //println(xml.name + " " + attrs.getAttributeName(1) + "=" + attrs.getAttributeValue(1) + " :: " + R.id.stub_no_connection)
        stub = ViewStub(context, attrs)
        //stub.layoutInflater = inflater.cloneInContext(context)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(stub, layout_params)
        xml.nextLog() // </ViewStub>

        xml.nextLog() // <ImageButton>
//        println(xml.name + " " + attrs.getAttributeName(1) + "=" + attrs.getAttributeValue(1) + " :: " + R.id.fab)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(ImageButton(context, attrs), layout_params)
        xml.nextLog() // </ImageButton>

        xml.nextLog() // <ViewStub>
//        println(xml.name + " " + attrs.getAttributeName(1) + "=" + attrs.getAttributeValue(1) + " :: " + R.id.stub_posting_progress)
        stub = ViewStub(context, attrs)
        //stub.layoutInflater = inflater.cloneInContext(context)
        layout_params = frame.generateLayoutParams(attrs)
        frame.addView(stub, layout_params)
        xml.nextLog() // </ViewStub>

        view.addView(frame, frame_params)
        xml.nextLog() // </FrameLayout>

        xml.next() // <RecyclerView>
//        println(xml.name + " " + attrs.getAttributeName(2) + "=" + attrs.getAttributeValue(2) + " :: " + R.id.filters)
        val layout_params2 = view.generateLayoutParams(attrs)
        view.addView(RecyclerView(context, attrs), layout_params2)

        // We aren't actually going to read the rest of this parse, so don't call it.
        //xml.next() // </RecyclerView>
        //xml.next() // </DrawerLayout>

        return view
    }
}