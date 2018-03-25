import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NewComponentComponent } from './new-component/new-component.component';
import { InlineComponentComponent } from './inline-component/inline-component.component';
import { BindingComponentComponent } from './binding-component/binding-component.component';


@NgModule({
  declarations: [
    AppComponent,
    NewComponentComponent,
    InlineComponentComponent,
    BindingComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
