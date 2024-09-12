import axios from 'axios';
import React, { ReactPropTypes as PT } from 'react';
import { Navigate, Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { createBrowserHistory as browserHistory } from 'history'
import CartSite from '../components/cart/CartSite';
import Footer from '../components/footer/Footer';
import Header from '../components/header/Header';
import Home from '../components/home/HomeContainer';
import FilterSite from '../components/main/FilterSite';
import SearchSite from '../components/main/SearchSite';
import ProductDetailSite from '../components/product/ProductDetailSite';
import LoginSite from '../components/user/LoginSite';
import RegisterSite from '../components/user/RegisterSite';

class RouteApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLogin: false,
      cart: []
    }
    this.handleAddToCart = this.handleAddToCart.bind(this);
    this.handleLogin = this.handleLogin.bind(this);
  }

  handleAddToCart(product) {
    this.setState({ cart: [...this.state.cart, product] })
  }

  handleLogin(email, password) {
    const _this = this;
    axios
      .get('../data/userdata.json')
      .then(res => {
        res.data.forEach(item => {
          if (item.email != email) return;
          if (item.password != password) return;
          _this.setState({ isLogin: true });
        })
      })
      .catch(err => console.log(err))
  }

  render() {

    const {
      handleAddToCart,
      handleLogin
    } = this;

    const {
      cart,
      isLogin
    } = this.state;

    return (
      <Router history={browserHistory}>
        <div id='body'>
          <Route children={({ location }) => {
            return (
              <Header location={location} cart={cart} />
            )
          }} />
          <Routes>
            <Navigate from='/home' to='/' />
            <Route exact path='/' component={Home} />
            <Route path='/search' component={SearchSite} />
            <Route path='/cart' children={() => {
              return (<CartSite isLogin={isLogin} cart={cart} handleLogin={handleLogin} />)
            }} />
            <Route path='/login' children={() => {
              return (<LoginSite isLogin={isLogin} handleLogin={handleLogin} />)
            }} />
            <Route path='/register' component={RegisterSite} />
            <Route path='/:category/:type/**' children={() => {
              return (<ProductDetailSite handleAddToCart={handleAddToCart} />)
            }} />
            <Route path='/:category' component={FilterSite} />
            <Navigate from='*' to='/' />
          </Routes>
          <Route component={Footer} />
        </div>
      </Router>
    )
  }
}

export default RouteApp;