import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ArticleGrid from './ArticleGrid.jsx';
import Article from './Article.jsx';
import VisibilityWrapper from './VisibilityWrapper.jsx';
import ArticleSourcesNavigation from './ArticleSourcesNavigation.jsx';
import axiosApi from './utils/axios-api.js';

class Main extends React.Component {

  constructor(props){
    	super(props);
    	this.state = {
          articles : [],
          selectedArticle: null
      };
  }

  componentDidMount() {
    axiosApi.get('http://192.168.1.19:8081/getAllArticles', function(response) {
      this.setState(
          function() {
            return {
              articles: response.data
            }
          }
      )}.bind(this)
    );
  }

  updateArticles4Source = (source) => {
    this.setState({articles: []})
    this.setState({selectedArticle: null})
    axiosApi.get('http://192.168.1.19:8081/getArticles4Source?source=' + source, function(response) {
        this.setState({articles: response.data})
      }.bind(this)
    )
  }

  selectArticleAction = (article) => {
      this.setState({selectedArticle : article});
  }

  render() {
    return (
      <div className="App">
        <ArticleSourcesNavigation dataProvierUrl="http://192.168.1.19:8081/getAllSources" updateArticles4SourceAction={this.updateArticles4Source}/>
        <div className="main-section">
          <VisibilityWrapper visible={this.state.selectedArticle == null}>
              <ArticleGrid articles={this.state.articles} selectArticleAction={this.selectArticleAction}/>
          </VisibilityWrapper>
          <VisibilityWrapper visible={this.state.selectedArticle != null}>
            <div className="main-content-area">
                <Article article={this.state.selectedArticle} articleClassName="article-selected-item"/>
            </div>
            <div className="right-content-area">
              <ArticleGrid articles={this.state.articles} selectArticleAction={this.selectArticleAction}/>
            </div>
          </VisibilityWrapper>
        </div>
      </div>
    );
  }
}

export default Main;
