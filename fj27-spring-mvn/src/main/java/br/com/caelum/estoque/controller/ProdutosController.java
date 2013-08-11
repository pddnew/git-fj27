package br.com.caelum.estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.estoque.Movimentacao;
import br.com.caelum.estoque.Produto;
import br.com.caelum.estoque.dao.MovimentacaoDAO;
import br.com.caelum.estoque.dao.ProdutoDAO;
import br.com.caelum.estoque.service.GeradorDeMovimentacao;

@RequestMapping("/produto")
@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private GeradorDeMovimentacao geradorDeMovimentacao;
	@Autowired
	private MovimentacaoDAO movimentacaoDAO;

	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	@Transactional
	public String alterar(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors())
			return "produtos/editar";

		produtoDAO.alterar(produto);
		Movimentacao mov = geradorDeMovimentacao.geraMovimentacao(produto);
		movimentacaoDAO.salvar(mov);

		return "redirect:/produto/listar";
	}

	@RequestMapping("/editar")
	public ModelAndView editar(Long id) {
		Produto produto = produtoDAO.buscarPorId(id);
		ModelAndView mav = new ModelAndView("produtos/editar");
		mav.addObject(produto);
		return mav;
	}

	@RequestMapping("/remover/{id}")
	public String remover(@PathVariable Long id) {
		Produto produto = produtoDAO.buscarPorId(id);
		produtoDAO.remover(produto);
		return "redirect:/produto/listar";
	}

	@RequestMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/produtos/excluir");
		mav.addObject(produtoDAO.buscarPorId(id));
		return mav;
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("produtoList", produtoDAO.listar());
		return "produtos/listar";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors())
			return "produtos/form";
		produtoDAO.salvar(produto);
		return "redirect:/produto/listar";
	}

	@RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
	public ModelAndView mostrar(@PathVariable Long id) {
		System.out.println(id);
		ModelAndView mav = new ModelAndView("produtos/mostrar");
		mav.addObject(produtoDAO.buscarPorId(id));
		return mav;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "produtos/form";
	}
}
